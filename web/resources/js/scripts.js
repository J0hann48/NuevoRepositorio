$(document).ready(function() {
    // Revisar Login
//    if(typeof localStorage.correoUsuario == "undefined"){
//        location.href = "../index.xhtml";
//    }else{
//        $("#userDiv, h1 b").html(localStorage.nombreUsuario);
//        $("#contenido_" + localStorage.usuarioTipo).fadeIn();
//    }
    // Demo Data
    /*if(localStorage.editado == 0){
        localStorage.data = JSON.stringify(data);
    }*/
    // Demo Data
    if(typeof localStorage.data == "undefined"){
        localStorage.data = JSON.stringify(data);
    }
    // Menu Principal
    $("#principalMenu").append('<li><a href="inicio.html">Inicio</a></li>');
    $.each(menuItems[localStorage.usuarioTipo].items, function(k, d){
        $("#principalMenu").append('<li><a href="' + d.url + '">' + d.nombre + '</a></li>');
    });
    // Archivos (Fase II)
    $.each(archivosItems, function(k, d){
        $("#archivosMenu").append('<li class="dropdown-header">' + d.titulo + '</li>');
        $.each(d.items, function(i, f){
            $("#archivosMenu").append('<li><a href="docs/' + f.url + '" target="_blank"><i class="fa fa-' + f.icon + '"></i> ' + f.nombre + '</a></li>');
        });
    });
    // Seccion Actual
    var seccion = window.location.pathname.split("/")[2];
    if(seccion != "inicio.html"){ // Si es diferente a Inicio (Home)
        $("#principalMenu").fadeIn();
    }else{ // Inicio
        var dataStored = JSON.parse(localStorage.data);
        // Usuarios
        // Alumnos
        // Profesores
        $("#totalProfesores").html(dataStored.profesores.length);
        profesoresPendientes = 0;
        $.each(dataStored.profesores, function(k, i){
            if(i.estado == 0){
                profesoresPendientes++;
            }
        });
        $("#totalProfesoresPendientes").html(profesoresPendientes);
        // Asignaturas
        $("#totalAsignaturas").html(dataStored.asignaturas.length);
        asignaturasPendientes = 0;
        $.each(dataStored.asignaturas, function(k, i){
            if(i.estado == 0){
                asignaturasPendientes++;
            }
        });
        $("#totalAsignaturasPendientes").html(asignaturasPendientes);
    }
    // Datos Usuario
    if($("#datosUsuario").length > 0){
        var usuarioHtml = '<h4>Mis Datos</h4>' +
            '<img src="img/usuario_' + localStorage.usuarioTipo + '.png" class="img-responsive">' +
            '<h2>' + localStorage.nombreUsuario + '</h2>' +
            '<p>' + localStorage.correoUsuario + '</p>' +
            '<a class="btn btn-block btn-info" href="cuenta.html">Editar Perfil</a>';
        $("#datosUsuario").html(usuarioHtml);
    }
    // Usuarios
    if($(".listadoUsuarios").length > 0){
        mostrarUsuarios();
    } 
    // Alumnos
    if($(".listadoAlumnos").length > 0){
        mostrarAlumnos();
    }  
    // Profesores
    if($(".listadoProfesores").length > 0){
        mostrarProfesores();
    }    
    // Asignaturas
    if($(".listadoAsignaturas").length > 0){
        var dataAsignaturas = JSON.parse(localStorage.data).asignaturas;
        //$.each($(".listadoAsignaturas"), function(k, i){
        $.each(dataAsignaturas, function(k, i){
            console.log(k, i);
            switch(localStorage.usuarioTipo){
                case "0":
                    var checkbox = (i.estado == 0) ? '<input type="checkbox" class="chbx_asignatura" id="asignatura_' + k + '"> ' : '<input type="checkbox" class="chbx_asignatura" id="asignatura_' + k + '" checked> ' ;
                    $(".listadoAsignaturas").append('<li><label>' + checkbox + i.nombre + '</label></li>');
                    break;
                    
                case "1":
                    break;
                    
                case "2":
                    if(i.estado == 1){
                        $(".listadoAsignaturas").append('<li><label>' + i.nombre + '</label></li>');
                    }
                    break;
            }
            //console.log(k, i);
            /*if(localStorage.usuarioTipo == 2 && i.estado == 1){
                $(".listadoAsignaturas").append('<li><label>' + i.nombre + '</label></li>');
            }else{
                var checkbox = (i.estado == 0) ? '<input type="checkbox" class="chbx_asignatura" id="asignatura_' + k + '"> ' : '<input type="checkbox" class="chbx_asignatura" id="asignatura_' + k + '" checked> ' ;
                $(".listadoAsignaturas").append('<li><label>' + checkbox + i.nombre + '</label></li>');
            }*/
        });
        //console.log(dataAsignaturas);
    }
    // Desarrollo
    if($(".listadoDesarrollo").length > 0){
        mostrarDesarrollo();
        if(localStorage.usuarioTipo == 1){
            mostrarAlumnosDesarrollo();
        }
    } 
    if($(".listadoDesarrollo2").length > 0){
        mostrarDesarrollo2();
    }
    if($(".listadoDesarrollo3").length > 0){
        mostrarDesarrollo3();
    }
    // Calificaciones
    if($(".listadoCalificaciones").length > 0){
        mostrarCalificaciones();
    } 
    // Matriculas
    if($(".listadoMatriculas").length > 0){
        mostrarMatriculas();
    } 
    // Cuenta
    if($(".editorUsuario").length > 0){
        var dataUsuarios = JSON.parse(localStorage.data).usuarios;
        $("#imagenUsuario").html('<img src="img/usuario_' + localStorage.usuarioTipo + '.png" class="img-responsive">');
        $("#nombreUsuario").val(localStorage.nombreUsuario);
        $("#emailUsuario").val(localStorage.correoUsuario);
        $("#claveUsuario").val(dataUsuarios[localStorage.idUsuario].clave);
        $("#btnUsuarioEditar").attr("onclick", "guardarUsuario(" + localStorage.idUsuario + ")");
        //$("#nombreUsuario").val();
    }
});

//localStorage.editado = false;

// Usuarios
function mostrarUsuarios(){
    // Div
    $(".listadoUsuarios").empty();
    // Alumnos
    var dataUsuarios = JSON.parse(localStorage.data).usuarios;
    $.each(dataUsuarios, function(k, i){
        //console.log(k, i);
        var checkbox = (i.estado == 0) ? '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" disabled> ' : '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" checked disabled> ' ;
        var icon = (i.sexo == "M") ? 'male' : 'female' ;
        var output = '<i class="fa fa-' + iconosUsuarios[i.nivel] + ' fa-fw fa-2x"></i>Usuario: <b>' + i.usuario + '</b><br>Correo: <b>' + i.email + '</b>';
        $(".listadoUsuarios").append('<div class="col-md-4 list-item"><label>' + checkbox + output + '</label><button class="btn btn-block btn-warning" onclick="editarUsuario(' + k + ');">Editar Usuario</button></div>');
    });
}
function agregarUsuario(){
    if($("#nombreUsuario").val() != ""){
        var dataApp = JSON.parse(localStorage.data),
            dataUsuarios = JSON.parse(localStorage.data).usuarios;
        var nuevo = {
            usuario: $("#nombreUsuario").val(),
            email: $("#emailUsuario").val(),
            clave: $("#claveUsuario").val(),
            nivel: $("#tipoUsuario").val(),
            estado: $("#estadoUsuario").val()
        };
        dataUsuarios.push(nuevo);
        dataApp.usuarios = dataUsuarios;
        localStorage.data = JSON.stringify(dataApp);
        localStorage.editado = 1;
        $("#nuevoUsuarioDiv").html('').addClass("hidden");
        $("#formUsuario")[0].reset();
        mostrarUsuarios();
    }else{
        $("#nombreUsuario").focus();
    }
}
function editarUsuario(usuarioId){
    var dataUsuario = JSON.parse(localStorage.data).usuarios;
    $.each(dataUsuario, function(k, i){
        if(k == usuarioId){
            $("#tituloFormulario").html("Editar Usuario");
            $("#nombreUsuario").val(i.usuario);
            $("#emailUsuario").val(i.email);
            $("#claveUsuario").val(i.clave);
            $("#tipoUsuario").val(i.nivel);
            $("#estadoUsuario").val(i.estado);
            $("#btnUsuarioAgregar").addClass("hidden");
            $("#btnUsuarioEditar").removeClass("hidden").attr("onclick", "guardarUsuario(" + usuarioId + ")");
            console.log(i);
        }
    });
}
function guardarUsuario(usuarioId){
    if($("#nombreUsuario").val() != ""){
        var dataApp = JSON.parse(localStorage.data),
            dataUsuarios = JSON.parse(localStorage.data).usuarios;
        if($(".editorUsuario").length > 0){
            dataApp.usuarios[localStorage.idUsuario].usuario = $("#nombreUsuario").val();
            dataApp.usuarios[localStorage.idUsuario].email = $("#emailUsuario").val();
            dataApp.usuarios[localStorage.idUsuario].clave = $("#claveUsuario").val();
            localStorage.data = JSON.stringify(dataApp);
            localStorage.nombreUsuario = $("#nombreUsuario").val();
            localStorage.correoUsuario = $("#emailUsuario").val();
            localStorage.editado = 1;
            setTimeout(function(){
                location.href = "inicio.html";
            }, 500);
        }else{
            var nuevo = {
                usuario: $("#nombreUsuario").val(),
                email: $("#emailUsuario").val(),
                clave: $("#claveUsuario").val(),
                nivel: $("#tipoUsuario").val(),
                estado: $("#estadoUsuario").val()
            };
            dataApp.usuarios[usuarioId] = nuevo;
            localStorage.data = JSON.stringify(dataApp);
            localStorage.editado = 1;
            $("#formUsuario")[0].reset();
            mostrarUsuarios();
            $("#tituloFormulario").html("Nuevo Usuario");
            $("#btnUsuarioAgregar").removeClass("hidden");
            $("#btnUsuarioEditar").addClass("hidden");
        }
    }else{
        $("#nombreUsuario").focus();
    }
}
function nuevoUsuarioTipo(){
    //console.log();
    var tipoUsuario = $("#tipoUsuario").val();
    if(tipoUsuario == 1){
        var dataProfesores = JSON.parse(localStorage.data).profesores,
            output = '';
        output += '<label>' +
            'Activos:' +
            '<select class="form-control" id="tipoUsuarioProfesor" onchange="nuevoUsuarioProfesor()">' +
                '<option value="">- Seleccione uno -</option>';
        $.each(dataProfesores, function(k, d){
            if(d.estado == 1){
                output += '<option value="' + d.nombre + ',' + d.email + '">' + d.nombre + '</option>';
            }
        });
        output += '</select>' +
        '</label>';
        $("#nuevoUsuarioDiv").removeClass("hidden").html(output);
    }
}
function nuevoUsuarioProfesor(){
    var profesor = $("#tipoUsuarioProfesor").val();
    if(profesor != ""){
        p = profesor.split(",");
        $("#nombreUsuario").val(p[0]);
        $("#emailUsuario").val(p[1]);
        $("#claveUsuario").focus();
    }else{
        $("#nombreUsuario, #emailUsuario").val('');
    }
}

// Alumnos
function mostrarAlumnos(){
    // Div
    $(".listadoAlumnos").empty();
    // Alumnos
    var dataAlumnos = JSON.parse(localStorage.data).alumnos;
    $.each(dataAlumnos, function(k, i){
        //console.log(k, i);
        var checkbox = (i.estado == 0) ? '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" disabled> ' : '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" checked disabled> ' ;
        var icon = (i.sexo == "M") ? 'male' : 'female' ;
        var output = '<i class="fa fa-' + icon + ' fa-fw fa-2x"></i>Alumno: <b>' + i.nombre + '</b><br>Edad: <b>' + i.edad + '</b>';
        $(".listadoAlumnos").append('<div class="col-md-4 list-item"><label>' + checkbox + output + '</label><button class="btn btn-block btn-warning" onclick="editarAlumno(' + k + ');">Editar Alumno</button></div>');
    });
}
function agregarAlumno(){
    if($("#nombreAlumno").val() != ""){
        var dataApp = JSON.parse(localStorage.data),
            dataAlumnos = JSON.parse(localStorage.data).alumnos;
        var nuevo = {
            nombre: $("#nombreAlumno").val(),
            edad: $("#edadAlumno").val(),
            sexo: $("#sexoAlumno").val(),
            estado: $("#estadoAlumno").val()
        };
        dataAlumnos.push(nuevo);
        dataApp.alumnos = dataAlumnos;
        localStorage.data = JSON.stringify(dataApp);
        localStorage.editado = 1;
        $("#formAlumno")[0].reset();
        mostrarAlumnos();
    }else{
        $("#nombreAlumno").focus();
    }
}
function editarAlumno(alumnoId){
    var dataAlumno = JSON.parse(localStorage.data).alumnos;
    $.each(dataAlumno, function(k, i){
        if(k == alumnoId){
            $("#tituloFormulario").html("Editar Alumno");
            $("#nombreAlumno").val(i.nombre);
            $("#edadAlumno").val(i.edad);
            $("#sexoAlumno").val(i.sexo);
            $("#estadoAlumno").val(i.estado);
            $("#btnAlumnoAgregar").addClass("hidden");
            $("#btnAlumnoEditar").removeClass("hidden").attr("onclick", "guardarAlumno(" + alumnoId + ")");
        }
    });
}
function guardarAlumno(alumnoId){
    if($("#nombreAlumno").val() != ""){
        var dataApp = JSON.parse(localStorage.data),
            dataAlumnos = JSON.parse(localStorage.data).alumnos;
        var nuevo = {
            nombre: $("#nombreAlumno").val(),
            edad: $("#edadAlumno").val(),
            sexo: $("#sexoAlumno").val(),
            peso: dataAlumnos[alumnoId].peso,
            talla: dataAlumnos[alumnoId].talla,
            estado: $("#estadoAlumno").val()
        };
        dataApp.alumnos[alumnoId] = nuevo;
        localStorage.data = JSON.stringify(dataApp);
        localStorage.editado = 1;
        $("#formAlumno")[0].reset();
        mostrarAlumnos();
    }else{
        $("#nombreAlumno").focus();
    }
}

// Profesores
function mostrarProfesores(){
    // Div
    $(".listadoProfesores").empty();
    // Asignaturas
    var dataAsignaturas = JSON.parse(localStorage.data).asignaturas;
    $.each(dataAsignaturas, function(k, i){
        if(i.estado == 1){
            $("#asignaturasProfesor").append('<option value="' + i.nombre + '">' + i.nombre + '</option>');
        }
    });
    // Profesores
    var dataProfesores = JSON.parse(localStorage.data).profesores;
    $.each(dataProfesores, function(k, i){
        //console.log(k, i);
        var checkbox = (i.estado == 0) ? '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" disabled> ' : '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" checked disabled> ' ;
        var icon = (i.sexo == "M") ? 'male' : 'female' ;
        var output = '<i class="fa fa-' + icon + ' fa-fw fa-3x"></i>Docente: <b>' + i.nombre + '</b><br>Materias: <b>' + i.materias + '</b><br>Email: <b>' + i.email + '</b>';
        $(".listadoProfesores").append('<div class="col-md-4 list-item"><label>' + checkbox + output + '</label><button class="btn btn-block btn-warning" onclick="editarProfesor(' + k + ');">Editar Profesor</button></div>');
    });
}
function agregarProfesor(){
    if($("#nombreProfesor").val() != ""){
        var dataApp = JSON.parse(localStorage.data),
            dataProfesores = JSON.parse(localStorage.data).profesores;
        if($("#asignaturasProfesor").val() != null){
            asignaturasProfesor = $("#asignaturasProfesor").val().toString();
        }else{
            asignaturasProfesor = '';
        }
        var nuevo = {
            nombre: $("#nombreProfesor").val(),
            materias: asignaturasProfesor,
            email: $("#emailProfesor").val(),
            sexo: $("#sexoProfesor").val(),
            estado: $("#estadoProfesor").val()
        };
        dataProfesores.push(nuevo);
        dataApp.profesores = dataProfesores;
        localStorage.data = JSON.stringify(dataApp);
        localStorage.editado = 1;
        $("#formProfesor")[0].reset();
        mostrarProfesores();
    }else{
        $("#nombreProfesor").focus();
    }
}
function editarProfesor(profesorId){
    var dataProfesor = JSON.parse(localStorage.data).profesores;
    $.each(dataProfesor, function(k, i){
        if(k == profesorId){
            $("#tituloFormulario").html("Editar Profesor");
            $("#asignaturasProfesor option:selected").removeAttr("selected");
            $("#nombreProfesor").val(i.nombre);
            $("#emailProfesor").val(i.email);
            $("#sexoProfesor").val(i.sexo);
            $("#estadoProfesor").val(i.estado);
            if(i.materias.indexOf(",") != -1){
                var m = i.materias.split(",");
                $.each(m, function(c, d){
                    $('#asignaturasProfesor option[value=\'' + d + '\']').attr('selected', true);
                });
            }else{
                $('#asignaturasProfesor option[value=\'' + i.materias + '\']').attr('selected', true);
            }
            $("#btnProfesorAgregar").addClass("hidden");
            $("#btnProfesorEditar").removeClass("hidden").attr("onclick", "guardarProfesor(" + profesorId + ")");
        }
    });
}
function guardarProfesor(profesorId){
    if($("#nombreProfesor").val() != ""){
        var dataApp = JSON.parse(localStorage.data),
            dataProfesores = JSON.parse(localStorage.data).profesores;
        if($("#asignaturasProfesor").val() != null){
            asignaturasProfesor = $("#asignaturasProfesor").val().toString();
        }else{
            asignaturasProfesor = '';
        }
        var nuevo = {
            nombre: $("#nombreProfesor").val(),
            materias: asignaturasProfesor,
            email: $("#emailProfesor").val(),
            sexo: $("#sexoProfesor").val(),
            estado: $("#estadoProfesor").val()
        };
        dataApp.profesores[profesorId] = nuevo;
        localStorage.data = JSON.stringify(dataApp);
        localStorage.editado = 1;
        $("#formProfesor")[0].reset();
        mostrarProfesores();
    }else{
        $("#nombreProfesor").focus();
    }
}

// Asignaturas
function guardarAsignaturas(){
    $.each($("#list_0 .chbx_asignatura"), function(k, i){
        if($(i).is(':checked')){
            data.asignaturas[k].estado = 1;
        }else{
            data.asignaturas[k].estado = 0;
        }
    });
    localStorage.data = JSON.stringify(data);
    localStorage.editado = 1;
    console.log(data.asignaturas);
}

// Desarrollo
function mostrarDesarrollo(){
    var dataApp = JSON.parse(localStorage.data),
        output = '',
        c = 0;
    output += '<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">';
    $.each(dataApp.alumnos, function(k, a){
        if(a.estado == 1){
            opened = (c == 0) ? 'true' : 'false';
            output += '<div class="panel panel-default">' +
                '<div class="panel-heading" role="tab" id="heading' + k + '">' +
                    '<h4 class="panel-title">' +
                        '<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse' + k + '" aria-expanded="' + opened + '" aria-controls="collapse' + k + '">' +
                            a.nombre +
                        '</a>' +
                    '</h4>' +
                '</div>' +
                '<div id="collapse' + k + '" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading' + k + '">' +
                    '<div class="panel-body">' +
                        graficasDesarrollo(a.peso, a.talla) +
                    '</div>' +
                '</div>' +
            '</div>';
            c++;
            if(localStorage.usuarioTipo == 2){
                return false;
            }
        }
    });
    output += '</div>';
    $(".listadoDesarrollo").html(output);
}
function mostrarDesarrollo2(){
    var dataApp = JSON.parse(localStorage.data),
        output = '',
        c = 0;
    output += '<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">';
    $.each(dataApp.alumnos, function(k, a){
        if(a.estado == 1){
            opened = (c == 0) ? 'true' : 'false';
            output += '<div class="panel panel-default">' +
                '<div class="panel-heading" role="tab" id="heading2' + k + '">' +
                    '<h4 class="panel-title">' +
                        '<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse2' + k + '" aria-expanded="' + opened + '" aria-controls="collapse' + k + '">' +
                            a.nombre +
                        '</a>' +
                    '</h4>' +
                '</div>' +
                '<div id="collapse2' + k + '" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading' + k + '">' +
                    '<div class="panel-body">' +
                        graficasDesarrollo(a.peso, a.talla) +
                    '</div>' +
                '</div>' +
            '</div>';
            c++;
            if(localStorage.usuarioTipo == 2){
                return false;
            }
        }
    });
    output += '</div>';
    $(".listadoDesarrollo2").html(output);
}
function mostrarDesarrollo3(){
    var dataApp = JSON.parse(localStorage.data),
        output = '',
        c = 0;
    output += '<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">';
    $.each(dataApp.alumnos, function(k, a){
        if(a.estado == 1){
            opened = (c == 0) ? 'true' : 'false';
            output += '<div class="panel panel-default">' +
                '<div class="panel-heading" role="tab" id="heading3' + k + '">' +
                    '<h4 class="panel-title">' +
                        '<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse3' + k + '" aria-expanded="' + opened + '" aria-controls="collapse' + k + '">' +
                            a.nombre +
                        '</a>' +
                    '</h4>' +
                '</div>' +
                '<div id="collapse3' + k + '" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading' + k + '">' +
                    '<div class="panel-body">' +
                        graficasDesarrollo(a.peso, a.talla) +
                    '</div>' +
                '</div>' +
            '</div>';
            c++;
            if(localStorage.usuarioTipo == 2){
                return false;
            }
        }
    });
    output += '</div>';
    $(".listadoDesarrollo3").html(output);
}
function graficasDesarrollo(peso, talla){
    // Peso
    var dataPeso = peso.split(","),
        outputPeso = '<div class="col-md-6">' +
            '<h4>Peso</h4>' +
            '<div class="barras-holder">';
    $.each(dataPeso, function(i, p){
        outputPeso += '<div class="barra-holder">' + 
            '<p>' + p + ' kg</p>' + 
            '<div class="barra-desarrollo" style="height: ' + p + 'px;"></div>' +
        '</div>';
    });
    outputPeso += '</div>' +
    '</div>';
    
    // Talla
    var dataTalla = talla.split(","),
        outputTalla = '<div class="col-md-6">' +
            '<h4>Estatura</h4>' +
            '<div class="barras-holder">';
    $.each(dataTalla, function(i, t){
        outputTalla += '<div class="barra-holder">' + 
            '<p>' + t + ' cm</p>' + 
            '<div class="barra-desarrollo" style="height: ' + t + 'px;"></div>' +
        '</div>';
    });
    outputTalla += '</div>' +
    '</div>';
    return outputPeso + outputTalla;
}
function agregarDesarrolloAlumno(){
    console.log("agregarDesarrolloAlumno");
    var appData = JSON.parse(localStorage.data);
    //
    idAlumno = $("#listadoDesarrolloAlumno").val();
    pesoAlumno = $("#pesoAlumno").val();
    tallaAlumno = $("#tallaAlumno").val();
    //
    pesoActual = appData.alumnos[idAlumno].peso;
    pesoNuevo = pesoActual + ',' + pesoAlumno;
    //
    tallaActual = appData.alumnos[idAlumno].talla;
    tallaNuevo = tallaActual + ',' + tallaAlumno;
    //
    appData.alumnos[idAlumno].peso = pesoNuevo;
    appData.alumnos[idAlumno].talla = tallaNuevo;
    localStorage.data = JSON.stringify(appData);
    mostrarDesarrollo();
    mostrarDesarrollo2();
    mostrarDesarrollo3();
}
function mostrarAlumnosDesarrollo(){
    // Div
    //$("#listadoDesarrolloAlumno").empty();
    // Alumnos
    var dataAlumnos = JSON.parse(localStorage.data).alumnos;
    $.each(dataAlumnos, function(k, i){
        //console.log(k, i);
        var checkbox = (i.estado == 0) ? '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" disabled> ' : '<input type="checkbox" class="chbx_profesor" id="profesor_' + k + '" checked disabled> ' ;
        var icon = (i.sexo == "M") ? 'male' : 'female' ;
        var output = '<i class="fa fa-' + icon + ' fa-fw fa-2x"></i>Alumno: <b>' + i.nombre + '</b><br>Edad: <b>' + i.edad + '</b>';
        //$(".listadoAlumnos").append('<div class="col-md-4 list-item"><label>' + checkbox + output + '</label><button class="btn btn-block btn-warning" onclick="editarAlumno(' + k + ');">Editar Alumno</button></div>');
        $("#listadoDesarrolloAlumno").append('<option value="' + k + '">' + i.nombre + '</div>');
    });
}

// Calificaciones
function mostrarCalificaciones(){
    var dataApp = JSON.parse(localStorage.data),
        output = '',
        c = 0;
    output += '<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">';
    $.each(dataApp.alumnos, function(k, a){
        if(a.estado == 1){
            opened = (c == 0) ? 'true' : 'false';
            output += '<div class="panel panel-default">' +
                '<div class="panel-heading" role="tab" id="heading' + k + '">' +
                    '<h4 class="panel-title">' +
                        '<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse' + k + '" aria-expanded="' + opened + '" aria-controls="collapse' + k + '">' +
                            a.nombre +
                        '</a>' +
                    '</h4>' +
                '</div>' +
                '<div id="collapse' + k + '" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading' + k + '">' +
                    '<div class="panel-body">';
            $.each(dataApp.asignaturas, function(i, d){
                if(d.estado == 1){
                    output += barraCalificaciones(d.nombre);
                }
            });
            output += '</div>' +
                '</div>' +
            '</div>';
            c++;
            if(localStorage.usuarioTipo == 2){
                return false;
            }
        }
    });
    output += '</div>';
    $(".listadoCalificaciones").html(output);
}
function barraCalificaciones(asignatura){
    var nota = numeroRandom(2,10);
    if(nota >= 2 && nota <= 5){
        color = 'danger';
    }else if(nota >= 6 && nota <= 8){
        color = 'warning';
    }else{
        color = 'success';
    }
    var output = '<div class="progress">' +
        '<div class="progress-bar progress-bar-' + color + '" role="progressbar" aria-valuenow="' + nota + '" aria-valuemin="0" aria-valuemax="10" style="width: ' + (nota * 10) + '%">' +
            '<span class="sr-only">' + (nota * 10) + '% Complete (success)</span>' +
            asignatura + ' (' + nota + '/10)' +
        '</div>' +
    '</div>';
    return output;
}

// Matriculas
function mostrarMatriculas(){
    var dataApp = JSON.parse(localStorage.data);
    $.each(dataApp.matriculas, function(k, d){
        $(".listadoMatriculas").append('<li>' + d.id + ' / ' + d.fecha + '</li>');
    });
}

// Inicio
function activarModal(modalParaActivar){
    switch(modalParaActivar){
        case "usuarios":
            modalTitle = 'Agregar Nuevo Usuario';
            modalBody = '';
            modalFooter = 'agregarUsuario();';
            break;
            
        default:
            modalTitle = 'Agregar Nuevo... ' + modalParaActivar;
            modalBody = '';
            modalFooter = '';
            
    }
    $("#modalTitle").html(modalTitle);
    $("#modalBody").html(modalBody);
    $("#modalFooter button").attr("onclick", modalFooter);
    $("#myModal").modal();
    console.log(modalParaActivar);
}

// Generales
function numeroRandom(min,max){
    return Math.floor(Math.random()*(max-min+1)+min);
}
function salirSistema(){
    //localStorage.clear();
    localStorage.removeItem('idUsuario');
    localStorage.removeItem('correoUsuario');
    localStorage.removeItem('nombreUsuario');
    localStorage.removeItem('usuarioTipo');
    setInterval(function(){
        location.href = "index.xhtml";
    }, 500);
}