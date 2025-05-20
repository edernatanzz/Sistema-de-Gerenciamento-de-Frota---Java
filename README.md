# **🚗 Sistema de Gerenciamento de Frota**  

**Desenvolvido por:**  
👨‍💻 **Éder Natan Azevedo Figueiredo**  
👨‍💻 **Douglas Aleixo**  

---

## **📌 Sobre o Projeto**  
Trabalho desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** na **UFBA**, ministrada pelo professor **Rodrigo Rocha**.  

O sistema foi construído em **Java** e tem como objetivo gerenciar frotas de veículos, incluindo:  
✔ **Cadastro de veículos e tipos**  
✔ **Controle de condutores (motoristas)**  
✔ **Registro de operações (viagens, uso de veículos)**  
✔ **Agendamento de manutenções**  
✔ **Registro de abastecimentos**  
✔ **Geração de relatórios**  

---

## **🎯 Objetivo**  
Automatizar o gerenciamento de frotas, garantindo:  
✅ **Controle eficiente** de veículos e motoristas  
✅ **Redução de custos** com manutenção e combustível  
✅ **Relatórios organizados** para tomada de decisão  

---

## **🔧 Funcionalidades**  

### **1. 🚗 Módulo de Veículos**  
- Cadastro de **carros, caminhões, ambulâncias**  
- Controle de **status** (disponível, em uso, em manutenção)  
- Validação de **documentação** (licenciamento, seguro)  

### **2. 👤 Módulo de Condutores**  
- Cadastro de **motoristas**  
- Verificação de **CNH e categoria**  
- Controle de **disponibilidade**  

### **3. ⚙️ Módulo de Operações**  
- **Agendamento de viagens**  
- **Registro de quilometragem**  
- **Designação de veículo e condutor**  

### **4. 🔧 Módulo de Manutenção**  
- **Agendamento preventivo e corretivo**  
- **Registro de custos**  

### **5. ⛽ Módulo de Abastecimento**  
- **Registro de combustível**  
- **Cálculo de consumo médio**  

### **6. 📊 Relatórios**  
- **Histórico de operações**  
- **Gastos com manutenção e combustível**  

---

## **🛠️ Tecnologias Utilizadas**  
- **Linguagem:** Java (JDK 17+)  
- **Banco de Dados:** SQLite (embarcado)  
- **Controle de Versão:** Git  

---

## **📥 Como Executar?**  

### **Pré-requisitos**  
✔ **Java JDK 17+** instalado  
✔ **Git** (opcional, para clonar o repositório)  

### **Passos para Execução**  
1. **Clone o repositório (ou baixe o .zip):**  
   ```bash
   git clone [link-do-repositorio]
   ```
2. **Compile o projeto:**  
   ```bash
   javac src/main/App.java
   ```
3. **Execute:**  
   ```bash
   java -cp src main.App
   ```

---

## **📄 Estrutura do Projeto**  
```
📁 frota-ufba/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 model/       # Classes de domínio (Veículo, Condutor, etc.)
│   │   ├── 📁 repository/  # Acesso a dados
│   │   ├── 📁 service/     # Regras de negócio
│   │   ├── 📁 util/        # Utilitários
│   │   └── App.java        # Classe principal
│   └── 📁 test/            # Testes unitários
├── 📁 docs/                # Documentação adicional
├── 📄 README.md            # Este arquivo
└── 📄 MANUAL.md            # Manual de uso detalhado
```

---

## **📜 Licença**  
Este projeto é um trabalho acadêmico e não possui licença aberta.  

---

## **📌 Contato**  
✉ **Éder Natan:** [eder@example.com]  
✉ **Douglas Aleixo:** [douglas@example.com]  

---

**Desenvolvido com ❤️ para a disciplina de POO @ UFBA**  
**Professor:** Rodrigo Rocha  
**Data de Entrega:** [insira a data]  

--- 
