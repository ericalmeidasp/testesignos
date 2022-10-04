### Squad 4 - Itália

```bash
Caique Vidal Freitas
Cristiano Roberto Oliveira
Daiane Leandro Oliveira
Davi Carrer
Eric Leonidas G Almeida
Joao Lucas Cruz Lopes
```

## Exercício 1 em GRUPO:

## Programação Funcional - Java (Consumer, Predicate, Supplier)

```bash
main class
org.auladesignos.desafiojuliano.DesafioProgramacaoFuncionalApplication.java
```

Baseado em uma lista de data de nascimento, escreva métodos para cada um dos itens abaixo.
Para o Consumer, Predicate e Supplier, o código deve ser escrioa com classe anônima e com labda.

Consumer para data formatada (dd/MM/yyyy HH:mm:ss)
Predicate para informar se a pessoa é da geração Z (nasceu entre 1995 e 2010)
Supplier para informar os signos com as datas
Ordernar datas de nascimento com comparator
A entrega pode ser feita através de arquivo anexo ou disponibilização pelo github, basta colar o link do projeto. Não
esqueçam de informar os integrantes do grupo.

## Exercício 2 em AULA, Em GRUPO.

### Criar uma base de dados (pode ser em memória) de pessoas com os seguintes atributos e extrair as informações

```bash
main class
org.auladesignos.desafiojuliano.desafiotarefa.Desafio03OutubroApplication.java
```

### Atributos

- Nome
- Cidade de nascimento
- Data de nascimento
- Signo (com base na data de nascimento)
- Idade (com base na data de nascimento)
- Geração (X, Y, Z ou Boomer, com base na data de nascimento)


1. Obter a lista de pessoas que são do signo X e tem mais de Y anos.
2. Obter a lista e a quantidade de pessoas que são menor e maior de idade
3. Obter a lista de pessoas que pertencem a geração {}
4. Obter a lista de todas as pessoas e informar a idade delas na próxima copa do mundo
5. Obter a pessoa mais velha e mais nova
6. Calcular a idade média e total das pessoas

# SIGNOS # MAPA ASTRAL

#### Atividade Individual

```bash
main class
org.auladesignos.sistemasignoslucas.SistemaSignosApplication.java
```

Você foi contratado para desenvolver o novo sistema de mapa astral de um grande banco.
Esse mapa astral não segue totalmente o padrão convencional, porque a empresa decidiu criar o seu próprio com algumas
especificações que seguem abaixo:

Você deve criar um método que receba a data/hora de nascimento e local de nascimento de uma pessoa. (Pode usar Scanner,
se quiser, mas não é obrigatório)
Baseado nessas informações, a equipe espera que você imprima:

- A idade
- Se o ano de nascimento foi um ano bissexto
- Data de nascimento formatada (dd/MM/yyy HH:MM)
- TZ do local de nascimento
- O signo
    - Implementar pelo menos dois signos.
    - Se não for encontrado, pode retornar "Signo não encontrado" ou algo parecido.
- O ascendente
    - Implementar pelo menos um ascendente para cada signo, baseado na hora de nascimento.
    - Se não for encontrado, pode retornar "Ascendente não encontrado" ou algo parecido.
- Signo lunar (bônus)
    - Implementar o signo lunar baseado no local e hora de nascimento
        - Se a pessoa nasceu em Recife e depois das 12h00, deve retornar "Casimiro"
        - Se a pessoa nasceu em Cuiaba e antes das 12h00, deve retornar "Odin"
        - Se a pessoa nasceu em São Paulo (não importa o horário), deve retornar "Gandalf"
        - Em qualquer outro caso, deve retornar: "Em construção"

    