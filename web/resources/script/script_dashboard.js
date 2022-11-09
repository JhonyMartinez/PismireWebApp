// ---------------------------------------------------------------
// Dashboard Administrador
// ---------------------------------------------------------------

// Pantalla de Carga - Loader 
const fadeout = () =>{
  const loaderWrapper = document.querySelector('.cargando');
  loaderWrapper.classList.add('fade');
}

window.addEventListener('load', fadeout);

// Minimizar Barra de Navegeacion Lateral
let boton = document.querySelector("#menu");
let barra = document.querySelector(".nav_lateral");

boton.onclick = function(){
  barra.classList.toggle("activa");
}

// Menu de Opciones
let boton2 = document.querySelector(".parte3");
let opciones = document.querySelector(".menu_opciones");

boton2.onclick = function(){
  opciones.classList.toggle("abrir");
}

// Mantener Seleccionada una Seccion
let secciones = document.querySelectorAll(".seccion");

secciones.forEach(seccion =>{
  seccion.addEventListener('click', function(){
    secciones.forEach(btn => btn.classList.remove('seleccionado'));
    this.classList.add('seleccionado');
  })
})

// Sublista - Mostrar
let listElements = document.querySelectorAll('.e-lista-click');

listElements.forEach(listElement => {
  listElement.addEventListener('click', ()=>{
    listElement.classList.toggle('abrir-sublist');

    barra.classList.remove("activa");

    let height = 0;
    let menu = listElement.nextElementSibling;

    if(menu.clientHeight == "0"){
      height = menu.scrollHeight;
    }

    menu.style.height = height+"px";


  })
});

// Ventana Modal -Ajustes
let open_modal = document.querySelector('.open_modal');
let modal = document.querySelector('.modal');
let close_modal = document.querySelector('.close_modal');

open_modal.addEventListener('click', (e)=>{
  e.preventDefault();
  modal.classList.add('modal_show');
})
close_modal.addEventListener('click', (e)=>{
  e.preventDefault();
  modal.classList.remove('modal_show');

  setTimeout(() => {
    contenido1.style.display = "block";
    contenido2.style.display = "none";

    contenedor.style.height = "auto";
    contenedor.style.width = "750px";
    contenedor.style.padding = "3rem 2.5rem";

    frame.src = "";
  }, 1000);

})

let ajustes_botones = document.querySelectorAll('.ajuste');
let contenido1 = document.querySelector('.contenido_principal');
let contenido2 = document.querySelector('.contenido_cargado');
let contenedor = document.querySelector('.modal_container');
let frame = document.querySelector('.iframe');

ajustes_botones.forEach(ajuste => {
  ajuste.addEventListener('click', (e)=>{
    e.preventDefault();
    contenido1.style.display = "none";
    contenido2.style.display = "block";
  
    contenedor.style.height = 90+"%";
    contenedor.style.width = 90+"%";
    contenedor.style.padding = "2rem 1.5rem";

    frame.src = ajuste.href;
  })
})
