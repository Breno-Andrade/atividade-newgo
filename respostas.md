# Estágio NewGo
Breno Andrade da Silva.

---

## Questões dissertativas:


---

### 1. Quais são os contras de utilizar se herança entre classes? Quais alternativas você adotaria caso quisesse deixar de usar herança em um relacionamento específico? Dê um exemplo.

**Resposta:** A utilização de herança gera um acoplamento entre as classes o que dificulta em incrementos e modificações. (Não tenho conhecimento sobre alternativas a serem adotadas).

---

### 2. Suponha que você tem uma classe final, da qual você não tem o código-fonte, e que você deseja adicioná-la a uma estrutura de polimorfismo, mas cuja interface pública é ligeiramente diferente da classe. Que padrão de projeto você poderia utilizar para aproveitar o código desta classe, mas fazendo com que ela atenda à interface da esperada na estrutura de polimorfismo?

**Resposta:** (Não possuo experiência na aplicação de padrões de projeto).

---

### 3. Em que cenários você poderia usar um proxy? Dê um exemplo real.
	
**Resposta:** (Não possuo experiência na aplicação de padrões de projeto).

---

### 4. Você prefere utilizar domínios anêmicos ou ricos? Como avalia os prós e contras de cada?

**Resposta:** (Não possuo conhecimento sobre domínios anêmicos e ricos.) 

---

#### 5. Dê um exemplo do bom uso do princípio OCP, da sigla SOLID.

**Resposta:** O principio de aberto e fechado define que devemos desenvolver aplicações abertas para novos incrementos mas fechadas para modificações. (Não possuo experiência com a aplicação dos princípios SOLID).

---

### 6. Qual é a diferença entre requisitos funcionais, não-funcionais e regras de negócio. Dê um exemplo de cada.
**Resposta:** Requisitos funcionais dizem respeito a funcionalidades que o sistema deve apresentar, exemplo: O sistema deve permitir que o usuario calcule o frete dos itens no carrinho. Requisitos não-funcionais dizem respeito a características genéricas do sistema: O sistema deve ser rápido; O sistema deve ser estável. Por fim, as regras de negócio dizem respeito a características o negócio que impactam nas funcionalidades do sistema, por exemplo: Para comprar acima de 100 reais, o cliente deve receber 3% de desconto para pagamentos em até duas vezes. 

---

### 7. Quais estratégias de diagramação você utiliza em seus projetos? Quais diagramas e por quê?
**Resposta:** Não tenho o habito de utilizar diagramas nos meus projetos, por serem bem simples acredito que não tenha a necessidade.

---

### 8. Você está utilizando GitFlow e precisa fazer uma alteração na versão em desenvolvimento de um projeto. Quais etapas você teria que realizar?
**Resposta:** De forma conceitual, a primeira etapa é identificar qual o tipo de alteração devemos realizar, por exemplo: Correção; Incremento; Alteração em funcionalidade. Após isso identificar de qual branch devemos ramificar para realizar o procedimento, por fim, após concluído as alterações e testes, devemos unir novamente a branch ramificada com a de desenvolvimento. (Não possuo experiência na utilização de GitFlow.)
	
---

### 9. O que você deve ter feito para que uma funcionalidade que você pegou para implementar seja considerada como 'done'?
**Resposta:** Implementado os requisitos solicitados e realizado os testes para identificar possíveis erros, se os testes não apontarem um comportamento estranho, podemos informar ao superior que a funcionalidade está pronta para ser revisada. Se o superior, após revisão, aprovar a solução desenvolvida podemos marca-la como 'done'.

---

### 10. Quais são as cerimônias do SCRUM e como você avalia a importância de cada?
**Resposta:** As cerimônias são importantes, pois impactam diretamente no dia a dia desenvolvendo soluções e interagindo com a equipe.

* Sprint Planning: Apesar de não ter a participação dos desenvolvedores nessa etapa, ela é de grande importância, pois nela será definido as funcionalidades a serem desenvolvidas na sprint.

* Daily Meeting: Apresenta uma grande importância por se trata de um momento para o alinhamento com a equipe sobre as tarefas do dia.

* Sprint Review: É importante para expor as "conquistas" alcançadas durante a sprint, dessa forma, nessa cerimonia identificamos como a equipe progrediu com as tasks propostas para a sprint atual.

* Sprint Retrospective: Por ser o momento ideal para informar as dificuldades encontradas durante a sprint, essa cerimonia é importante para os ajustes das futuras sprints.

---

### 11. Você conhece e utiliza Docker nos seus projetos? Se sim, para que?
**Resposta:** (Não possuo conhecimento teórico ou prático sobre docker).

---

## Diagramas:

---

### Diagrama de classes.

```

@startuml

class Pasta {
  - nome: String
  - subpastas: ArrayList<Pasta>
  - arquivos: ArrayList<Arquivo>
  --
  + Pasta(nome: String)
  + Pasta(nome: String, subpasta: Pasta)
  + Pasta(nome: String, arquivo: Arquivo)
  + Pasta(nome: String, subpasta: Pasta, arquivo: Arquivo)
  + Pasta(nome: String, subpastas: ArrayList<Pasta>, arquivos: ArrayList<Arquivo>)
  + getNome(): String
  + alterarNome(nome: String): void
  + getSubpastas(): ArrayList<Pasta>
  + setSubpastas(subpastas: ArrayList<Pasta>): void
  + inserirSubpasta(subpasta: Pasta): void
  + excluirSubpasta(subpasta: Pasta): void
  + getArquivos(): ArrayList<Arquivo>
  + setArquivos(arquivos: ArrayList<Arquivo>): void
  + inserirArquivo(arquivo: Arquivo): void
  + deletarArquivo(arquivo: Arquivo): void
  + toString(): String
}

class Arquivo {
  - nome: String
  - tipo: String
  - tamanho: double
  --
  + Arquivo(nome: String, tipo: String, tamanho: double)
  + getNome(): String
  + setNome(nome: String): void
  + getTipo(): String
  + setTipo(tipo: String): void
  + getTamanho(): double
  + setTamanho(tamanho: double): void
  + toString(): String
}

class CalculaTamanhoTotalDaPasta {
  + calcularTamanhoDaPasta(pasta: Pasta): double
}

class VerificaSeExistemSubpastas {
  + TemSubpastas(pasta: Pasta): boolean
}

Pasta -- Pasta: subpastas
Pasta -- Arquivo: arquivos
CalculaTamanhoTotalDaPasta --> Pasta
VerificaSeExistemSubpastas --> Pasta

@enduml

```
---
### Diagrama de sequencia:
```
@startuml

actor Usuário

participant "Arquivo" as Arquivo
participant "Pasta" as Pasta
participant "CalculaTamanhoTotalDaPasta" as CalculaTamanhoTotalDaPasta


Usuário -> Arquivo: Criar Arquivo 01
activate Arquivo
Arquivo --> Usuário: Arquivo 01 criado

Usuário -> Arquivo: Criar Arquivo 02
activate Arquivo
Arquivo --> Usuário: Arquivo 02 criado

Usuário -> Arquivo: Criar Arquivo 03
activate Arquivo
Arquivo --> Usuário: Arquivo 03 criado

Usuário -> Pasta: Criar subpasta
activate Pasta
Pasta --> Usuário: Subpasta criada

Usuário -> subpasta: Inserir Arquivo 01
activate subpasta
subpasta -> Arquivo: Inserir Arquivo 01
activate Arquivo
Arquivo --> subpasta: Arquivo 01 inserido

Usuário -> subpasta: Inserir Arquivo 02
subpasta -> Arquivo: Inserir Arquivo 02
Arquivo --> subpasta: Arquivo 02 inserido

Usuário -> Pasta: Criar pasta
Pasta --> Usuário: Pasta criada

Usuário -> pasta: Inserir subpasta
activate pasta
pasta -> subpasta: Inserir subpasta
pasta --> Usuário: Subpasta inserida

Usuário -> pasta: Inserir Arquivo 03
pasta -> Arquivo: Inserir Arquivo 03
Arquivo --> pasta: Arquivo 03 inserido

Usuário -> CalculaTamanhoTotalDaPasta: Calcular tamanho da pasta
activate CalculaTamanhoTotalDaPasta
CalculaTamanhoTotalDaPasta -> pasta: Calcular tamanho da pasta
pasta -> subpasta: Calcular tamanho da subpasta
activate subpasta
subpasta -> Arquivo: Obter tamanho dos arquivos
activate Arquivo
Arquivo --> subpasta: Tamanho dos arquivos obtido
deactivate Arquivo
subpasta --> pasta: Tamanho da subpasta calculado
deactivate subpasta
CalculaTamanhoTotalDaPasta --> Usuário: Tamanho total da pasta calculado

Usuário -> Usuário: Exibir informações da pasta
deactivate CalculaTamanhoTotalDaPasta
Usuário --> Usuário: Informações exibidas


@enduml

```