function criptografar(texto) {
    return texto
        .replace(/a/g, "ai")
        .replace(/e/g, "enter")
        .replace(/i/g, "imes")
        .replace(/o/g, "ober")
        .replace(/u/g, "ufat");
}

function descriptografar(texto) {
    return texto
        .replace(/ai/g, "a")
        .replace(/enter/g, "e")
        .replace(/imes/g, "i")
        .replace(/ober/g, "o")
        .replace(/ufat/g, "u");
}

document.getElementById("cripto_button").addEventListener("click", function() {
    let user_input = document.getElementById("input_js").value;
    let user_output = criptografar(user_input);
    document.getElementById("temp_div").style.display = "none";

    document.getElementById("out_text").textContent = user_output;
    document.getElementById("output2").style.display = "block";
});

document.getElementById("descripto_button").addEventListener("click", function() {
    let user_input = document.getElementById("input_js").value;
    let user_output = descriptografar(user_input);
    document.getElementById("temp_div").style.display = "none";

    document.getElementById("out_text").textContent = user_output;
    document.getElementById("output2").style.display = "flex";
});