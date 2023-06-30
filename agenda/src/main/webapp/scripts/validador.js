/**
 * Validador de formulários
 * @author Lucas Victor Costa Silva 2023
 */
function validar() {
  let nome = frmContato.nome.value;
  let fone = frmContato.fone.value;
  let email = frmContato.email.value;

  if (nome === '') {
    alert('Preencha o campo "Nome"');
    frmContato.nome.focus();
    return false;
  } else if (fone === '') {
    alert('Preencha o campo "Telefone"');
    frmContato.fone.focus();
    return false;
  } else if (!validarEmail(email)) {
    alert('Digite um e-mail válido');
    frmContato.email.focus();
    return false;
  } else {
    document.forms["frmContato"].submit();
  }
}

function validarEmail(email) {
  var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}
 
  function confirmar(idcon){
	 let resposta = confirm("Realmente deseja excluir esse contato? ")
	 
	 if (resposta === true){
		window.location.href = "delete?idcon=" + idcon
	 }
 }
 
