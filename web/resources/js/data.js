// Secciones Disponibles segun Rol de Usuario
var menuItems = [
    {
        items: [
            {
                nombre: 'Gestion de usuarios',
                url: 'usuarios.html'
            },
            {
                nombre: 'Alumnos',
                url: 'alumnos.html'
            },
            {
                nombre: 'Profesores',
                url: 'profesores.html'
            },
            {
                nombre: 'Asignaturas',
                url: 'asignaturas.html'
            },
            
            {
                nombre: 'Calificaciones',
                url: 'calificaciones.html'
            },
            {
                nombre: 'Matriculas',
                url: 'matriculas.html'
            },
            {
                nombre: 'Desarrollo',
                url: 'desarrollo.html'
            },
            {
                nombre: 'Actividades',
                url: 'actividades.html'
            },
            {
                nombre: 'Recordatorios',
                url: 'recordatorios.html'
            },
        ]
    },
    {
        items: [
            {
                nombre: 'Alumnos',
                url: 'alumnos.html'
            },
            {
                nombre: 'Asignaturas',
                url: 'asignaturas.html'
            },
            {
                nombre: 'Calificaciones',
                url: 'calificaciones.html'
            },
            {
                nombre: 'Actividades',
                url: 'actividades.html'
            },
            {
                nombre: 'Desarrollo',
                url: 'desarrollo.html'
            },
            {
                nombre: 'Recordatorios',
                url: 'recordatorios.html'
            },
        ]
    },
    {
        items: [
            {
                nombre: 'Asignaturas',
                url: 'asignaturas.html'
            },
            {
                nombre: 'Calificaciones',
                url: 'calificaciones.html'
            },
            {
                nombre: 'Actividades',
                url: 'actividades.html'
            },
            {
                nombre: 'Desarrollo',
                url: 'desarrollo.html'
            },
            {
                nombre: 'Matriculas',
                url: 'matriculas.html'
            },
        ]
    },
];

// Configuracion Fase II
var archivosItems = [
    {
        titulo: 'Diseño Web',
        items: [
            {
                nombre: 'ERROR 404',
                url: 'ERROR-404.png',
                icon: 'file-image-o'
            },
            {
                nombre: 'ERROR-5OO',
                url: 'ERROR-500.png',
                icon: 'file-image-o'
            },
            {
                nombre: 'MANUAL CORPORATIVO',
                url: 'Manual-Corporativo.pdf',
                icon: 'file-pdf-o'
            },
        ]
    },
    {
        titulo: 'Ingenieria Software',
        items: [
            {
                nombre: 'Archivo 1',
                url: 'link 1',
                icon: 'file-pdf-o'
            },
            {
                nombre: 'Archivo 1',
                url: 'link 1',
                icon: 'file-powerpoint-o'
            },
        ]
    },
    {
        titulo: 'Ingles',
        items: [
            {
                nombre: 'Archivo 1',
                url: 'link 1',
                icon: 'file-pdf-o'
            },
        ]
    },
    {
        titulo: 'Componente Comunicacion',
        items: [
            {
                nombre: 'Archivo 1',
                url: 'link 1',
                icon: 'file-pdf-o'
            },
        ]
    },
    {
        titulo: 'Componente Emprendimiento',
        items: [
            {
                nombre: 'Archivo 1',
                url: 'link 1',
                icon: 'file-pdf-o'
            },
        ]
    },
];

// Iconos Usuarios
var iconosUsuarios = ['star', 'star-half-full', 'star-o'];

// Demo Data
var data = {
    usuarios: [
        {
            usuario: 'Administrador',
            email: 'yasuaza73@misena.edu.co',
            nivel: 0,
            clave: 'emelyn2016',
            estado: 1
        },
        {
            usuario: 'Jaime Herrera',
            email: 'jherrera@mijardin.com',
            nivel: 1,
            clave: 'juanita2014',
            estado: 1
        },
        {
            usuario: 'Ruby Caicedo',
            email: 'ruby@3erojo.com',
            nivel: 2,
            clave: 'juanitabb',
            estado: 1
        },
    ],
    alumnos: [
        {
            nombre: 'Juanita Herrera',
            edad: 3,
            sexo: 'F',
            peso: '12',
            talla: '84',
            estado: 1
        },
        {
            nombre: 'Emelyn Niño',
            edad: 5,
            sexo: 'F',
            peso: '11',
            talla: '84',
            estado: 1
        },
        {
            nombre: 'Gabriel Herrera',
            edad: 2,
            sexo: 'M',
            peso: '14',
            talla: '84',
            estado: 0
        },
        {
            nombre: 'Julian Rios',
            edad: 3,
            sexo: 'M',
            peso: '13',
            talla: '83',
            estado: 1
        },
        {
            nombre: 'Andres Buitrago',
            edad: 4,
            sexo: 'M',
            peso: '12',
            talla: '82',
            estado: 0
        },
        {
            nombre: 'Sebastian Perez',
            edad: 5,
            sexo: 'M',
            peso: '13',
            talla: '84',
            estado: 0
        },
        {
            nombre: 'Oscar Riaño',
            edad: 3,
            sexo: 'M',
            peso: '11',
            talla: '86',
            estado: 1
        },
        {
            nombre: 'Harold Yepes',
            edad: 2,
            sexo: 'M',
            peso: '11',
            talla: '84',
            estado: 1
        },
        {
            nombre: 'Diego Ortiz',
            edad: 5,
            sexo: 'M',
            peso: '11',
            talla: '85',
            estado: 1
        },
        {
            nombre: 'Angela Saavedra',
            edad: 4,
            sexo: 'F',
            peso: '12',
            talla: '84',
            estado: 0
        },
        {
            nombre: 'Paula Gomez',
            edad: 3,
            sexo: 'F',
            peso: '13',
            talla: '85',
            estado: 1
        },
        {
            nombre: 'Leidy Gutierrez',
            edad: 4,
            sexo: 'F',
            peso: '11',
            talla: '84',
            estado: 0
        },
    ],
    profesores: [
        {
            nombre: 'Mauricio Olaya',
            materias: 'Pre-matematicas',
            email: 'molaya@mijardin.com',
            sexo: 'M',
            estado: 0
        },
        {
            nombre: 'Armando Gomez',
            materias: 'Deportes',
            email: 'agomez@mijardin.com',
            sexo: 'M',
            estado: 0
        },
        {
            nombre: 'Luz Mila Solarte',
            materias: 'Ingles',
            email: 'lsolarte@mijardin.com',
            sexo: 'F',
            estado: 1
        },
        {
            nombre: 'Ricardo Perez',
            materias: 'Musica,Artes',
            email: 'rperez@mijardin.com',
            sexo: 'M',
            estado: 1
        },
        {
            nombre: 'Julia Martinez',
            materias: 'Lenguaje,Escritura',
            email: 'jmartinez@mijardin.com',
            sexo: 'F',
            estado: 0
        },
        {
            nombre: 'Eduardo Hurtado',
            materias: 'Expresion Corporal',
            email: 'ehurtado@mijardin.com',
            sexo: 'M',
            estado: 1
        },
        {
            nombre: 'Jaime Herrera',
            materias: 'Religion,Etica',
            email: 'jherrera@mijardin.com',
            sexo: 'M',
            estado: 1
        },
    ],
    padres: [],
    asignaturas: [
        {
            nombre: 'Ingles',
            estado: 1
        },
        {
            nombre: 'Musica',
            estado: 1
        },
        {
            nombre: 'Artes',
            estado: 1
        },
        {
            nombre: 'Lenguaje',
            estado: 0
        },
        {
            nombre: 'Expresion Corporal',
            estado: 0
        },
        {
            nombre: 'Religion',
            estado: 0
        },
        {
            nombre: 'Deportes',
            estado: 0
        },
        {
            nombre: 'Pre-matematicas',
            estado: 1
        },
        {
            nombre: 'Escritura',
            estado: 0
        },
        {
            nombre: 'Etica',
            estado: 0
        }
    ],
    calificaciones: [],
    matriculas: [
        {
            id: '00103',
            fecha: '2016-06-10',
            estado: 1
        },
        {
            id: '00325',
            fecha: '2016-06-11',
            estado: 1
        },
        {
            id: '00524',
            fecha: '2016-06-11',
            estado: 0
        },
        {
            id: '00645',
            fecha: '2016-06-11',
            estado: 1
        },
        {
            id: '00655',
            fecha: '2016-06-12',
            estado: 0
        },
        {
            id: '00165',
            fecha: '2016-06-14',
            estado: 0
        },
        {
            id: '00754',
            fecha: '2016-06-15',
            estado: 1
        },
        {
            id: '00877',
            fecha: '2016-06-15',
            estado: 1
        },
        {
            id: '00545',
            fecha: '2016-06-15',
            estado: 1
        },
        {
            id: '00757',
            fecha: '2016-06-16',
            estado: 0
        },
    ],
    pagos: [],
    actividades: [],
    recordatorios: [],
    alimentacion: []
};