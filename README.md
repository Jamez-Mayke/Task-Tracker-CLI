# 📝 Task Tracker CLI

O **Task Tracker CLI** é uma aplicação simples de linha de comando desenvolvida em **Java**, criada para gerenciar tarefas de forma prática e rápida.  
Com ela, é possível adicionar, listar, atualizar, remover e alterar o status de tarefas diretamente pelo terminal.

---

## 🚀 Funcionalidades Implementadas

✅ **Adicionar tarefa** : Permite criar uma nova tarefa com uma descrição informada pelo usuário.
```bash
java TaskTrackerCli add "Descrição da tarefa"
```

✅ **Listar tarefas** : Exibe todas as tarefas cadastradas, mostrando ID, descrição e status.
```bash
java TaskTrackerCli list
```

✅ **Atualizar descrição da tarefa** : Atualiza a descrição de uma tarefa existente informando o ID e a nova descrição.
```bash
java TaskTrackerCli update <id> "Nova descrição"
```

✅ **Remover tarefa** : Remove uma tarefa da lista com base no ID informado.
```bash
java TaskTrackerCli delete <id>
```

✅ **Marcar tarefa como “em progresso”** : Atualiza o status de uma tarefa para In Progress.
```bash
java TaskTrackerCli mark-in-progress <id>
```

✅ **Marcar tarefa como “concluída”** : Atualiza o status de uma tarefa para Done.
```bash
java TaskTrackerCli mark-done <id>
```

## 📂 Estrutura do Projeto
```bash
src/
├── Task.java              # Classe que representa a entidade de uma tarefa
├── TaskManager.java       # Responsável por armazenar e manipular as tarefas
├── Status.java            # Enum que representa os status possíveis da tarefa
└── TaskTrackerCli.java    # Classe principal da aplicação (CLI)
```

## 💾 Persistência
As tarefas são armazenadas e lidas a partir de um arquivo JSON, garantindo que os dados sejam preservados mesmo após o encerramento da aplicação.

## 🧠 Próximos Passos
* Implementar busca de tarefas por status
* Adicionar data de criação e de conclusão
* Melhorar o formato de exibição no terminal
* Implementar ordenação por status ou data


## 🛠 Tecnologias Utilizadas
Java 17+ | Biblioteca JSON (Jackson) | CLI via Terminal


## 🧩 Como Executar o Programa
Siga os passos abaixo para rodar o **Task Tracker CLI** em seu ambiente local:


### 🪄 1. Compile o projeto
No terminal, dentro da pasta onde está o código-fonte (`src`), compile todos os arquivos Java:

```bash
javac src/*.java # Isso irá gerar os arquivos .class necessários para execução.
```

### ⚙️ 2. Execute os comandos disponíveis
Após compilar, você pode executar o programa diretamente pelo terminal com:
```bash
java TaskTrackerCli <comando> [parâmetros]
```

## 🧠 Exemplos de uso

🆕 **Adicionar uma nova tarefa**
```bash
java TaskTrackerCli add "Estudar Java"
```

📋 **Listar todas as tarefas**
```bash
java TaskTrackerCli list
```

✏️ **Atualizar a descrição de uma tarefa**
```bash
java TaskTrackerCli update 1 "Estudar Java e Spring Boot"
```

🗑️ **Remover uma tarefa**
```bash
java TaskTrackerCli delete 1
```

🚧 **Marcar tarefa como “em progresso”**
```bash
java TaskTrackerCli mark-in-progress 2
```

✅ **Marcar tarefa como “concluída”**
```bash
java TaskTrackerCli mark-done 3
```

### 💾 Arquivo de dados

As tarefas são salvas automaticamente em um arquivo tasks.json, criado na pasta do projeto.
Esse arquivo armazena todas as informações de forma persistente, mesmo após fechar o programa.

🔁 **Recompilar após alterações**

Sempre que alterar qualquer arquivo .java, recompilar antes de executar novamente:
```bash
javac *.java
```

