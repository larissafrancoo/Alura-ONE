let listaDeNumerosSoteados = [];
novoJogo();
let numeroSecreto = gerarNumeroAleatorio();
let tentativas = 1;

function novoJogo() {
    escreverNaTela('h1', 'Jogo do número secreto');
    escreverNaTela('p', 'Escolha um número entre 1 e 10');
}

function escreverNaTela(tag, texto)
{
    let campo = document.querySelector(tag);
    campo.innerHTML = texto;
    responsiveVoice.speak(texto, 'Brazilian Portuguese Female',
    {rete:1.5});
}

function gerarNumeroAleatorio() {
    let numeroAleatorio = parseInt(Math.random() * 10 + 1);
    let quantidadeDeElementosNaLista = listaDeNumerosSoteados.length;
    if (quantidadeDeElementosNaLista == 10)
        listaDeNumerosSoteados = [];
    if (listaDeNumerosSoteados.includes(numeroAleatorio)) {
        return gerarNumeroAleatorio();
    } else {
        listaDeNumerosSoteados.push(numeroAleatorio)
        return numeroAleatorio;
    }
}

function consoleClick() {
    let chute = document.querySelector('input').value;
    let mensagemTentativas = `Você descobriu o número secreto com ${tentativas} tentativas.`;
    if (chute != numeroSecreto) {
        if (chute > numeroSecreto)
            escreverNaTela('p', 'O número secreto é menor');
        else if (chute < numeroSecreto)
            escreverNaTela('p', 'O número secreto é maior');
        tentativas++;
    }
    else {
        if (tentativas == 1)
            mensagemTentativas = 'Você descobriu o número secreto com 1 tentativa.';
        escreverNaTela('h1', 'Acertou!');
        escreverNaTela('p', mensagemTentativas);
        limparCampo();
        document.getElementById('reiniciar').removeAttribute('disabled');
    }
}

function limparCampo() {
    chute = document.querySelector('input');
    chute.value = '';
}

function reiniciarJogo() {
    numeroSecreto = gerarNumeroAleatorio();
    limparCampo();
    tentativas = 1;
    novoJogo();
    document.getElementById('reiniciar').setAttribute('disabled', true);
}