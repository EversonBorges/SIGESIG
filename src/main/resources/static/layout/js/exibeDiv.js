function exibe(id) {  
   if(document.getElementById("idAddAlunoEL").value=="") {  
        document.getElementById(id).style.display = "none";  
    }    
    else {  
        document.getElementById(id).style.display = "inline";  
    }     
}