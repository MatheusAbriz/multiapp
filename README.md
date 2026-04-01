# App Hub de Utilidades

Um aplicativo Android desenvolvido em Java que funciona como um "Hub" de ferramentas essenciais. Este projeto tem como foco o gerenciamento de múltiplas telas (Activities), passagem de parâmetros via Intents, persistência básica de estado e implementação de lógica condicional estruturada.

## Funcionalidades

O aplicativo conta com um Menu Principal que dá acesso a 4 módulos distintos:

* ** Sorteador da MegaSena:** Gera 6 números aleatórios (de 1 a 60) para jogos, com opção de limpar os dados.
* ** Calculadora de IMC:** Recebe peso e altura, processa o cálculo matemático e envia os dados para uma segunda tela que exibe a classificação do Índice de Massa Corporal.
* ** Jokenpo (Pedra, Papel e Tesoura):** Clássico jogo "Melhor de 3" contra o computador (PC), com persistência de placar durante as rodadas e opção de reiniciar a partida.
* ** Questionário da Felicidade:** Um módulo exclusivo que calcula uma pontuação baseada em pesos predefinidos sobre a qualidade do sono e níveis de estresse do usuário, gerando uma classificação final do estado de equilíbrio.

##  Tecnologias e Conceitos Aplicados

* **Linguagem:** Java
* **Layout:** XML (ConstraintLayout e LinearLayout)
* **Navegação:** Intents explícitas para transição entre Activities.
* **Passagem de Dados:** Uso de `putExtra` e `getIntent().getExtras()` (Aplicado no módulo IMC e Felicidade).
* **Gerenciamento de Pilha:** Uso do método `finish()` para garantir a consistência do botão "Voltar" customizado.
