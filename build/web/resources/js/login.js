    $(document).ready(function() {
    if(typeof localStorage.correoUsuario != "undefined"){
        location.href = "inicio.html";
    }
    // Demo Data
    if(typeof localStorage.data == "undefined"){
        localStorage.data = JSON.stringify(data);
    }
});
$('#myModal').on('shown.bs.modal', function () {
    $('#acudienteNombre').focus()
})
$('#myModal').on('hidden.bs.modal', function (e) {
    $('#formularioRegistro')[0].reset();
})

function showStorage(){
    alert(localStorage.name);
}
function registroPadre(){
    if($("#acudienteNombre").val() == ""){ // Acudiente Nombre
        // Agregar Clase
        $("#acudienteNombre").addClass("invalido").focus();
    }else if($("#acudienteDocumento").val() == ""){ // Acudiente Documento
        // Quitar Clase
        $("#acudienteNombre").removeClass("invalido");
        // Agregar Clase
        $("#acudienteDocumento").addClass("invalido").focus();
    }else if($("#acudienteCorreo").val() == ""){ // Acudiente Correo
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento").removeClass("invalido");
        // Agregar Clase
        $("#acudienteCorreo").addClass("invalido").focus();
    }else if($("#acudienteCelular").val() == ""){ // Acudiente Celular
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo").removeClass("invalido");
        // Agregar Clase
        $("#acudienteCelular").addClass("invalido").focus();
    }else if($("#acudienteResidenciaDireccion").val() == ""){ // Acudiente Direccion Residencia
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular").removeClass("invalido");
        // Agregar Clase
        $("#acudienteResidenciaDireccion").addClass("invalido").focus();
    }else if($("#acudienteResidenciaTelefono").val() == ""){ // Acudiente Telefono Residencia
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular, #acudienteResidenciaDireccion").removeClass("invalido");
        // Agregar Clase
        $("#acudienteResidenciaTelefono").addClass("invalido").focus();
    }else if($("#acudienteTrabajoDireccion").val() == ""){ // Acudiente Direccion Trabajo
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular, #acudienteResidenciaDireccion, #acudienteResidenciaTelefono").removeClass("invalido");
        // Agregar Clase
        $("#acudienteTrabajoDireccion").addClass("invalido").focus();
    }else if($("#acudienteTrabajoTelefono").val() == ""){ // Acudiente Telefono Trabajo
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular, #acudienteResidenciaDireccion, #acudienteResidenciaTelefono, #acudienteTrabajoDireccion").removeClass("invalido");
        // Agregar Clase
        $("#acudienteTrabajoTelefono").addClass("invalido").focus();
    }else if($("#estudianteNombre").val() == ""){ // Estudiante Nombre
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular, #acudienteResidenciaDireccion, #acudienteResidenciaTelefono, #acudienteTrabajoDireccion, #acudienteTrabajoTelefono").removeClass("invalido");
        // Agregar Clase
        $("#estudianteNombre").addClass("invalido").focus();
    }else if($("#estudianteDocumento").val() == ""){ // Estudiante Documento
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular, #acudienteResidenciaDireccion, #acudienteResidenciaTelefono, #acudienteTrabajoDireccion, #acudienteTrabajoTelefono, #estudianteNombre").removeClass("invalido");
        // Agregar Clase
        $("#estudianteDocumento").addClass("invalido").focus();
    }else if($("#usuarioClave").val() == ""){ // Contraseña
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular, #acudienteResidenciaDireccion, #acudienteResidenciaTelefono, #acudienteTrabajoDireccion, #acudienteTrabajoTelefono, #estudianteNombre, #estudianteDocumento").removeClass("invalido");
        // Agregar Clase
        $("#usuarioClave").addClass("invalido").focus();
    }else if($("#usuarioClave").val() != $("#usuarioConfirmar").val()){ // Confirmar Contraseña
        // Quitar Clase
        $("#acudienteNombre, #acudienteDocumento, #acudienteCorreo, #acudienteCelular, #acudienteResidenciaDireccion, #acudienteResidenciaTelefono, #acudienteTrabajoDireccion, #acudienteTrabajoTelefono, #estudianteNombre, #estudianteDocumento, #usuarioClave").removeClass("invalido");
        // Agregar Clase
        $("#usuarioConfirmar").addClass("invalido").focus();
    }else{
        localStorage.nombreUsuario = $("#acudienteNombre").val();
        localStorage.documentoUsuario = $("#acudienteDocumento").val();
        localStorage.correoUsuario = $("#acudienteCorreo").val();
        localStorage.claveUsuario = $("#usuarioClave").val();
        localStorage.nombreEstudiante = $("#estudianteNombre").val();
        localStorage.documentoEstudiante = $("#estudianteDocumento").val();
        localStorage.usuarioTipo = 2;
        var appData = JSON.parse(localStorage.data);
        var nuevo = {
            usuario: $("#acudienteNombre").val(),
            email: $("#acudienteCorreo").val(),
            nivel: 2,
            clave: $("#usuarioClave").val(),
            estado: 1
        }
        appData.usuarios.push(nuevo);
        localStorage.data = JSON.stringify(appData);
        $('#formularioRegistro')[0].reset();
        $('#loginForm')[0].reset();
        $('#myModal').modal('toggle');
        $("#loginEmail").val(localStorage.correoUsuario);
        $("#loginClave").val('').focus();
    }
}


function ingresarSistema(){
    if($("#loginEmail").val() == ""){ // Login Email
        // Agregar Clase
        $("#loginEmail").addClass("invalido").focus();
    }else if($("#loginClave").val() == ""){ // Login Clave
        // Quitar Clase
        $("#loginEmail").removeClass("invalido");
        // Agregar Clase
        $("#loginClave").addClass("invalido").focus();
    }else{
        var appData = JSON.parse(localStorage.data);
        if($("#loginEmail").val() == "yasuaza73@misena.edu.co" && $("#loginClave").val() == appData.usuarios[0].clave){
            // ADMIN
            localStorage.idUsuario = 0;
            localStorage.nombreUsuario = 'Administrador';
            localStorage.correoUsuario = $("#loginEmail").val();
            localStorage.usuarioTipo = 0;
            $('#loginForm')[0].reset();
            $("#loginStatus").html('Bienvenido <b>Administrador</b>... <i class="fa fa-spin fa-spinner"></i>');
            setTimeout(function(){
                location.href = "inicio.html";
                if(typeof localStorage.editado == "undefined"){
                    localStorage.editado = 0;
                }
            }, 2000);
        }else{
            // PROFESOR o PADRE DE FAMILIA
            if($("#loginTipo").val() == ""){ // Login Tipo
                // Quitar Clase
                $("#loginEmail, #loginClave").removeClass("invalido");
                // Agregar Clase
                $("#loginTipo").addClass("invalido").focus();
            }else{
                //
                $("#loginEmail, #loginClave, #loginTipo").removeClass("invalido");
                var tipoUsuario = $("#loginTipo").val(),
                    usuarioValido = false;
                $.each(appData.usuarios, function(u, d){
                    if($("#loginEmail").val() == d.email && $("#loginClave").val() == d.clave && tipoUsuario == d.nivel){
                        usuarioValido = true;
                        dataUsuario = d;
                        idUsuario = u;
                    }
                });
                if(usuarioValido == true){
                    localStorage.idUsuario = idUsuario;
                    localStorage.nombreUsuario = dataUsuario.usuario;
                    localStorage.correoUsuario = dataUsuario.email;
                    localStorage.usuarioTipo = dataUsuario.nivel;
                    $('#loginForm')[0].reset();
                    if(tipoUsuario == 1){ // Profesor
                        $("#loginStatus").html('Bienvenido <b>Profesor</b>... <i class="fa fa-spin fa-spinner"></i>');
                    }else{
                        $("#loginStatus").html('Bienvenido <b>Padre de Familia</b>... <i class="fa fa-spin fa-spinner"></i>');
                    }
                    setTimeout(function(){
                        location.href = "inicio.html";
                        if(typeof localStorage.editado == "undefined"){
                            localStorage.editado = 0;
                        }
                    }, 2000);
                }else{
                    $("#loginStatus").html('Datos Invalidos. Por favor intente de nuevo.');
                    setTimeout(function(){
                        $("#loginStatus").html("");
                        $("#loginEmail").focus();
                    }, 2000);
                }
                /*if($("#loginTipo").val() == 1){ // Profesor
                    if($("#loginEmail").val() != "jherrera@mijardin.com"){
                        $("#loginStatus").html("Profesor No Registrado");
                    }else if($("#loginClave").val() != "juanita2014"){
                        $("#loginStatus").html("Clave Incorrecta");
                    }else{
                        localStorage.nombreUsuario = 'Profe Jaime';
                        localStorage.correoUsuario = $("#loginEmail").val();
                        localStorage.usuarioTipo = 1;
                        $('#loginForm')[0].reset();
                        $("#loginStatus").html('Bienvenido <b>Profesor</b>... <i class="fa fa-spin fa-spinner"></i>');
                        setInterval(function(){
                            location.href = "inicio.html";
                            if(typeof localStorage.editado == "undefined"){
                                localStorage.editado = 0;
                            }
                        }, 2000);
                    }
                }else if($("#loginTipo").val() == 2){ // Padre
                    if(typeof localStorage.nombreUsuario != "undefined"){
                        if($("#loginEmail").val() != localStorage.correoUsuario){
                            $("#loginStatus").html("Padre No Registrado");
                        }else if($("#loginClave").val() != localStorage.claveUsuario){
                            $("#loginStatus").html("Clave Incorrecta");
                        }else{
                            $('#loginForm')[0].reset();
                            $("#loginStatus").html('Bienvenido <b>Padre</b>... <i class="fa fa-spin fa-spinner"></i>');
                            setInterval(function(){
                                location.href = "inicio.html";
                                if(typeof localStorage.editado == "undefined"){
                                    localStorage.editado = 0;
                                }
                            }, 2000);
                        }
                    }else{
                        $("#acudienteCorreo").val($("#loginEmail").val());
                        $('#myModal').modal('toggle');
                    }   
                } */       
            }
        }
    }
    /**/
}

function borrarData(){
    localStorage.clear();
    setTimeout(function(){
        location.href = "index.html";
    }, 500);
}