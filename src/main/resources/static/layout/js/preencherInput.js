function add(value,value2){
  var resultado = document.getElementById('descricao');
  var res = document.getElementById('modulo');
  if(resultado.value == null && res.value == null){
	resultado.value += " " + value2;
	res.value += " " + value;
  }else{
  resultado.value = "";
  resultado.value += " " + value2;
  res.value = "";
  res.value += " " + value;
  }
}