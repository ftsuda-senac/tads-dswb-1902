function ready(fn) {
    if (document.attachEvent ? document.readyState === "complete" : document.readyState !== "loading") {
        fn();
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
}

ready(function() {
   // DO SOMETHING 
   alert('AVISO: Comparar o HTML do template Thymeleaf com o HTML carregado no navegador após o processamento')
});