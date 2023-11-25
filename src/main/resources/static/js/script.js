let formFilme = document.querySelector("#formFilme");
let titulo = document.querySelector("#titulo");
let sinopse = document.querySelector("#sinopse");
let genero = document.querySelector("#genero");
let anoLancamento = document.querySelector("#anoLancamento");

let formAnalise = document.querySelector("#formAnalise");
let analise = document.querySelector("#analise");
let nota = document.querySelector("#nota");

if(formFilme){
formFilme.addEventListener("submit", function () {
    event.preventDefault();

    if (titulo.value === "" || sinopse.value === "" || genero.value === "" || anoLancamento.value <= "0") {
        alert("Preencha todos os campos corretamente.");
        if (titulo.value === "") {
            titulo.style.border = "2px solid #EC4C4C";
        } else {
            titulo.style.border = "";
        }
        if (sinopse.value === "") {
            sinopse.style.border = "2px solid #EC4C4C";
        } else {
            sinopse.style.border = "";
        }
        if (genero.value === "") {
            genero.style.border = "2px solid #EC4C4C";
        } else {
            genero.style.border = "";
        }
        if (anoLancamento.value <= "0") {
            anoLancamento.style.border = "2px solid #EC4C4C";
        } else {
            anoLancamento.style.border = "";
        }
        return;
    }

    formFilme.submit();
});
}

if(formAnalise){
formAnalise.addEventListener("submit", function () {
    event.preventDefault();

    if (analise.value === "" || nota.value < "0") {
        alert("Preencha todos os campos corretamente.");
        if(analise.value === ""){
            analise.style.border = "2px solid #EC4C4C";
        }else{
            analise.style.border = "";
        }
        
        if(nota.value < "0"){
            nota.style.border = "2px solid #EC4C4C";
        }else{
            nota.style.border = "";
        }

        return;
    }

    formAnalise.submit();
});
}