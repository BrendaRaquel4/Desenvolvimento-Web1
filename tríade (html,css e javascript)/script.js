const texto = document.getElementById('p1');
const modal = document.getElementById('modalConfirmacao');

// Único manipulador para todas as interações
modal.addEventListener('click', (e) => {
  // Fecha se clicar cancelar ou fora da tela de confirmação
  if (e.target === modal || e.target.id === 'btnCancelar') {
    modal.style.display = 'none';
  }
  // Botão de confirmação (OK)
  else if (e.target.id === 'btnConfirmar') {
    const cores = ['vermelho', 'verde', 'azul'];
    const atual = texto.classList[0];
    texto.classList.replace(atual, cores[(cores.indexOf(atual) + 1) % 3]);
    modal.style.display = 'none';
  }
}
);

//clica no texto para exibição do modal
texto.addEventListener('click', () => modal.style.display = 'block');
