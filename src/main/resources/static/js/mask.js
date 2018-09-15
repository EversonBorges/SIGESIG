  $(document).ready(function(){
    	  $('.date').mask('00/00/0000');
    	  $('.time').mask('00:00:00');
    	  $('.cep').mask('00000-000');
    	  $('.rg').mask('AA-00.000.000');
    	  $('.phone').mask('(00) 00000-0000');
    	  $('.fixo').mask('(00) 0000-0000');
    	  $('.cnpj').mask('00.000.000/0000-00'); 
    	  $('.cpf').mask('000.000.000-00', {reverse: false});
    	  $('.money').mask('000.000.000.000.000,00', {reverse: false});
    	});
  
  //ESCONDE A DIV
  
  $().ready(function() {
		setTimeout(function () {
			$('#foo').hide(); // "foo" é o id do elemento que seja manipular.
		}, 3000); // O valor é representado em milisegundos.
	});
  
  //BUSCA CPF
  var baseUri = 'http://localhost:8080/membros/buscaCpf/'

	  function ValidaSim() {

	    var uri = baseUri + $('#txtValid').val();
	    alert(uri); // Remover esta linha depois quando implementar em seu projeto.
	    window.location = uri;

	  }
  
  function buscar(){
      alert('Salvar');
     var nome = document.getElementById("usuario").value;

  jQuery.ajax({
      type:  'POST',
      url:   'membros/empresa',
      dataType: 'json',
      data: {
          usuario     : nome
      },
      success: function(data){
         alert(data.response);
      }
  });       
}
