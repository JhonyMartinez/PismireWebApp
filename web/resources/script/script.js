// ---------------------------------------------------------------
// Pagina Principal y General
// ---------------------------------------------------------------

// Pantalla de Carga - Loader 
const fadeout = () =>{
  const loaderWrapper = document.querySelector('.cargando');
  loaderWrapper.classList.add('fade');
}

window.addEventListener('load', fadeout);

// Barra de Navegacion Estatica al hacer scroll
let ubicacionPrincipal = window.pageYOffset
let nav = document.querySelector('.nav');
let logo = document.querySelector('.img-logo');

window.addEventListener('scroll', function(){
  let ubicacionActual = this.window.pageYOffset;

  if (ubicacionPrincipal >= ubicacionActual) {
    nav.classList.add('estatica');
    logo.classList.add('estatica');
    menu.classList.remove('abierto');
    nav.classList.remove('abierto');

  } else {
    nav.classList.remove('estatica');
    logo.classList.remove('estatica');
  }

  ubicacionPrincipal = ubicacionActual;

  if (ubicacionPrincipal == 0) {
    nav.classList.remove('estatica');
    logo.classList.remove('estatica');
  }
})

// Utilizacion del Slider con Swiperjs - Mision/Vision
var swiper = new Swiper(".mySwiper", {
  spaceBetween: 30,
  grabCursor: true,
  loop: true, 
  centeredSlides: true,
  autoplay: {
    delay: 7000,
    disableOnInteraction: false,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});

// Galeria - Imagen Abierta
const fotos = document.querySelectorAll(".foto");
const galeria_abierta = document.querySelector(".galeria_abierta");
const foto_grande = document.querySelector(".foto_grande");

fotos.forEach(foto  =>{ 
  foto.addEventListener('click', ()=>{
    addFoto(foto.getAttribute('src'));
  })
})

const addFoto = (srcFoto) =>{
  nav.classList.remove('estatica');
  galeria_abierta.classList.toggle("abrir_foto");
  foto_grande.src = srcFoto;
}

galeria_abierta.addEventListener('click', ()=>{
  galeria_abierta.classList.toggle("abrir_foto");
})

// Utilizacion del Slider con Swiperjs - Menu del Dia

var swiper = new Swiper(".slider_contenido", {
  slidesPerView: 1,
  spaceBetween: 25,
  loop: true,
  centeredSlide:'true',
  autoplay: {
    delay: 5000,
    disableOnInteraction: false,
  },
  fade:'true',
  grabCursor: 'true',
  loopFillGroupWithBlank: true,
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
  pagination: {
    el: ".swiper-pagination",
  },
  breakpoints: {
    768: {
      slidesPerView: 2,
      spaceBetween: 25,
    },
    1024: {
      slidesPerView: 3,
      spaceBetween: 25,
    },
  },
});

// Menu de Navegacion Responsive
const menu = document.querySelector(".menu");
const menubtn = document.querySelector(".menu-btn");
const links = document.querySelectorAll(".secciones a");

menubtn.onclick = function(){
  menu.classList.toggle('abierto');
  nav.classList.toggle('abierto');
}

links.forEach(link  =>{ 
  link.addEventListener('click', ()=>{
    menu.classList.toggle('abierto');
    nav.classList.toggle('abierto');
  })
})