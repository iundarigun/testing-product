#language: pt
  Funcionalidade: Pesquisa de produtos

    Cenário: Pesquisa por id sem id
      Dado que o usuário deseje consultar pelo identificador
      Quando acionar a consulta com id vazio
      Então a consulta deve retornar uma exceção

    Cenário: Pesquisa por id inválido
      Dado que o usuário deseje consultar pelo identificador
      Quando acionar a consulta com id "AAA"
      Então a consulta deve retornar uma exceção

    Cenário: Pesquisa por id inexistente
      Dado que o usuário deseje consultar pelo identificador
      Quando acionar a consulta com id "95"
      Então a consulta não deve retornar produtos

    Cenário: Pesquisa por id válido
      Dado que o usuário deseje consultar pelo identificador
      Quando acionar a consulta com id "1"
      Então a consulta deve retornar o produto válido
      E o nome do produto deve ser "Moto G5 Plus"
      E a categoria do produto deve ser "telefonia"
