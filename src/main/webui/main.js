import './style.css'

const confirmButton = document.getElementById('confirmButton');
const numberInput = document.getElementById('numberInput');

confirmButton.addEventListener('click', async () => {
    const numberValue = numberInput.value;

    const response = await fetch(`/labseq/${numberValue}`, {
      method: 'GET',
      headers: {
          'Content-Type': 'text/plain',
      },
    });

    const result = await response.text();
    document.getElementById('outputBox').value = result;
});