// api-backend/server.js
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(cors());
app.use(bodyParser.json());

// Lista de usuários em memória (apenas para exemplo)
let users = [
  { id: 1, name: 'João', email: 'joao@example.com', phone: '123456789' },
  { id: 2, name: 'Maria', email: 'maria@example.com', phone: '987654321' }
];

// Rota para obter todos os usuários
app.get('/usuarios', (req, res) => {
  res.json(users);
});

// Rota para criar um novo usuário
app.post('/usuarios', (req, res) => {
  const newUser = req.body;
  newUser.id = users.length + 1;
  users.push(newUser);
  res.json(newUser);
});

// Rota para editar um usuário
app.put('/usuarios/:id', (req, res) => {
  const { id } = req.params;
  const updatedUser = req.body;

  const userIndex = users.findIndex(user => user.id == id);
  if (userIndex >= 0) {
    users[userIndex] = { id: parseInt(id), ...updatedUser };
    res.json(users[userIndex]);
  } else {
    res.status(404).send('Usuário não encontrado');
  }
});

// Rota para deletar um usuário
app.delete('/usuarios/:id', (req, res) => {
  const { id } = req.params;
  const userIndex = users.findIndex(user => user.id == id);
  if (userIndex >= 0) {
    users = users.filter(user => user.id !== parseInt(id));
    res.status(204).send();
  } else {
    res.status(404).send('Usuário não encontrado');
  }
});

app.listen(port, () => {
  console.log(`API rodando na porta ${port}`);
});
