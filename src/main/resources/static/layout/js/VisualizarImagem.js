// adiciona a imagem ao campo html img
function visualizarImg() {
    // indica qual campo img deve apresentar a imagem.// aqui o 3º campo da página html exbida - a númeração começa em 0).
	var preview = document.querySelectorAll('img').item(2);
    // indica o componente input do tipo file, que contém a imagem.
	var file = document.querySelector('input[type=file]').files[0];
	var reader = new FileReader();

	reader.onloadend = function() {
		preview.src = reader.result;// carrega em base64 a imagem
	};

	if (file) {
		reader.readAsDataURL(file);
	} else {
		preview.src = ""; // limpa a imagem

	}
}