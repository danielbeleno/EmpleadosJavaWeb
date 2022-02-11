<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados Java Web</title>
        <!--Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <!--DataTable-->
        <link rel="stylesheet" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.dataTables.min.css"/>
    </head>
    <body>
        <div class="container mt-4">
            <form id="form_empleado" autocomplete="off">
                <div class="card">
                    <div class="card-header" align="center">
                        <h3>Registro de empleados</h3>
                    </div>
                    <div class="card-body">
                        <div class="form-group mb-4">
                            <input class="form-control" type="text" placeholder="Nombre del empleado" id="nombre" name="nombre">
                        </div>
                        <div class="form-group mb-4">
                            <input class="form-control" type="number" placeholder="Cedula del empleado" id="cedula" name="cedula">
                        </div>
                        <div class="form-group mb-4">
                            <input class="form-control" type="date" id="fecha_cumple" name="fecha_cumple">
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" placeholder="Cargo del empleado" id="cargo" name="cargo">
                        </div>
                    </div>
                    <div class="card-footer" align="center">
                        <button class="btn btn-success" type="button" id="btn_registrar">Registrar</button>
                        <button class="btn btn-warning" type="reset">Limpiar</button>
                    </div>
                </div>
            </form>

        </div>
        <div class="container-fluid mt-4">
            <table class="table table-bordered table-striped display nowrap text-center" style="width:100%;" id="tb_empleado">
                <thead>
                    <tr>
                        <th>NOMBRE</th>
                        <th>CEDULA</th>
                        <th>FECHA_CUMPLE</th>
                        <th>CARGO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
            </table>
        </div>

        <div class="modal fade" id="modalForm" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar empleado</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="form_edit" autocomplete="off">
                            <div class="form-group mb-4">
                                <input class="form-control" type="text" placeholder="Nombre del empleado" id="edit_nombre">
                            </div>
                            <div class="form-group mb-4">
                                <input class="form-control" type="text" placeholder="Cedula del empleado" id="edit_cedula">
                            </div>
                            <div class="form-group mb-4">
                                <input class="form-control" type="date" id="edit_fecha_cumple">
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="text" placeholder="Cargo del empleado" id="edit_cargo">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="btn_guardar">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

        <!--JQuery-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

        <!--DataTable-->
        <script src="//cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>

        <!--SweetAlert-->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script src="js/app.js"></script>
    </body>
</html>
