/**
 * Validador de formulários
 * @author Lucas Victor Costa Silva 2023
 */

 function validar(){
	 let nome = frmContato.nome.value
	 let fone = frmContato.fone.value
	 
	 if (nome === ''){
		 alert('Preencha o campo "Nome"')
		 frmContato.nome.focus()
		 return false 
	 }else if (fone === ''){
		 alert('Preencha o campo "Telefone"')
		 frmContato.fone.focus()
		 return false
	 }else{
		 document.forms["frmContato"].submit()
	 }
 }
 
  function confirmar(idcon){
	 let resposta = confirm("Realmente deseja excluir esse contato? ")
	 
	 if (resposta === true){
		window.location.href = "delete?idcon=" + idcon
	 }
 }
 
