// Pantalla de Carga - Loader 
const fadeout = () =>{
    const loaderWrapper = document.querySelector('.cargando');
    loaderWrapper.classList.add('fade');
  }
  
  window.addEventListener('load', fadeout);