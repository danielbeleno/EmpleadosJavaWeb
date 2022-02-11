let edit_id = null;

const listar = () => {
    $("#tb_empleado").dataTable({
        responsive: true,
        destroy: true,
        ajax: {
            url: "ControladorEmpleado?accion=Listar",
            type: "POST",
            dataSrc: ""
        },
        columns: [
            {data: "nombre"},
            {data: "cedula"},
            {data: "fecha_cumple"},
            {data: "cargo"},
            {
                data: "id",
                render: function (data) {
                    return "<button class='btn btn-primary' type='button' data-bs-toggle='modal' data-bs-target='#modalForm' onclick='editar(" + data + ")'>Editar</button> <button class='btn btn-danger' type='button' onclick='eliminar(" + data + ")'>Eliminar</button>";
                }
            }
        ]
    });
};

const registrar = () => {
    $.ajax({
        url: "ControladorEmpleado?accion=Registrar",
        type: "POST",
        data: $("#form_empleado").serialize(),
        success: function (result) {
            if (result === "true") {
                swal("Empleado registrado", "El empleado se ha registrado con exito", "success");
                listar();
            } else {
                swal("Error al registrar", "No se ha podido registrar el empleado", "error");
            }
        }
    });
};

const editar = (id) => {
    alert(id);
    $.ajax({
        url: "ControladorEmpleado?accion=Editar",
        type: "POST",
        data: {id: id},
        success: function (result) {
            let datos = JSON.parse(result);
            edit_id = id;
            $("#edit_nombre").val(datos.nombre);
            $("#edit_cedula").val(datos.cedula);
            $("#edit_fecha_cumple").val(datos.fecha_cumple);
            $("#edit_cargo").val(datos.cargo);
        }
    });
};

const guardar = () => {
    $.ajax({
        url: "ControladorEmpleado?accion=Guardar",
        type: "POST",
        data: {
            id: edit_id,
            nombre: $("#edit_nombre").val(),
            cedula: $("#edit_cedula").val(),
            fecha_cumple: $("#edit_fecha_cumple").val(),
            cargo: $("#edit_cargo").val()
        },

        success: function (result) {
            if (result === "true") {
                swal("Empleado editado", "El empleado se ha editado con exito", "success");
                listar();
            } else {
                swal("Error al editar", "No se ha podido editar el empleado", "error");
            }
        }
    });
};

const eliminar = (id) => {
    alert(id);
    $.ajax({
        url: "ControladorEmpleado?accion=Eliminar",
        type: "POST",
        data: {
            id: id
        },
        success: function (result) {
            if (result === "true") {
                swal("Empleado eliminado", "El empleado se ha eliminado con exito", "success");
                listar();
            } else {
                swal("Error al eliminar", "No se ha podido eliminar el empleado", "error");
            }
        }
    });
};

$(document).ready(listar());
$("#btn_registrar").on("click", () => {
    registrar();
});
$("#btn_guardar").on("click", () => {
    guardar();
});