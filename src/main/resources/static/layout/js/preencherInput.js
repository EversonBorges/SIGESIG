function add(value){
  var resultado = document.getElementById('descricao');
  var res = document.getElementById('modulo');
  if(resultado.value == null && res.value == null){
	resultado.value += " " + value;
	res.value += " " + value;
  }else{
  resultado.value = "";
  resultado.value += " " + value;
  res.value = "";
  res.value += " " + value;
  }
}