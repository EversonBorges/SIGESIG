$("#form").submit(function(e) {
	
	var senha     = $("#senha").val();
	var repetSenha    = $("#repetSenha").val();
	
    if($("#senha").val() != $("#repetSenha").val()){
    	alert("As senhas são diferentes !"); 
    	e.preventDefault();
    	$("#senha").val("");
        $("#repetSenha").val("");
    }
});

