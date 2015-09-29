Locadora de veículos Loca Lisa

A Loca Lisa acaba de abrir uma rede de locadoras de veículos em Campina Grande. A presidente Lisa Abreu veio pessoalmente à nossa cidade a procura de uma equipe para desenvolver o sistema da empresa.
A Loca Lisa dispõe de automóveis e motocicletas. Os planos são baseados no modelo e características dos veículos. Assuma planos de A a G para automóveis e A a D para motocicletas (vide Caso de uso 5).
Os preços de locação variam de acordo com as diárias. A tabela disponível nesse link - http://www.alugueldecarro.com.br/unidas/ - segue uma lógica bem prática.

Exemplos:
Aluguel de 6 dias de um automóvel do plano A:
preço-base (1 a 7 dias): R$ 55,00
6 x R$ 55,00 = R$ 330,00
Aluguel de 10 dias de um automóvel do plano A:
preço-base (8 a 14 dias): R$ 53,00
10 x R$ 60,00 = R$ 530,00


As locações também podem utilizar planos com controle de quilometragem: até 125km, até 250km e até 500km.
Além do custo referente ao tipo de locação (diária ou quilometragem), o cliente pode optar (leia-se não é obrigatório) pela taxa de seguro que deve ser proporcional à cobertura do mesmo.
Atenção! O sistema não poderá utilizar banco de dados. Todos os dados persistentes devem ser armazenados em arquivo. É fortemente recomendado o uso de serialização de objetos.

Para o 1º milestone (21/10) será exigido:
Casos de uso de 1,2,3,4,5 e 9 - sem persistência
não é necessário manipular arquivos nessa etapa
Diagramas UML
Testes
Versão inicial do Javadoc


Para o 2º milestone (06/11) será exigido:
Todos os casos de uso
Atualização dos Diagramas UML
Testes
Atualização do Javadoc

3º milestone (25/11)


Descrição dos casos de uso:

Caso de uso 1: Manter registros dos veículos

O operador pode criar, editar e excluir registros de veículos. Como já foi citado, há dois tipos de veículos disponíveis: automóvel e motocicleta. O registro do primeiro deve apresentar, no mínimo: RENAVAM, modelo, marca, potência, ano, cor, tipo de combustível, data de aquisição, localização (agência) e descrição dos acessórios opcionais (ar condicionado, vidro elétrico, GPS,etc.). Os registros do segundo tipo devem apresentar: RENAVAM, modelo, marca, potência, cilindradas, ano, cor, tipo de combustível, tipo de freios, localização (agência) e data de aquisição.
Um importante requisito que também deve estar presente no registro de qualquer veículo é o nível do tanque. Esse atributo é importante para o controle de devolução do veículo que será descrito em próximos casos de uso.
Atenção! Uma vez que um veículo é adquirido e disponibilizado para locação, não é remendado a exclusão do registro do mesmo; essa ação é propagada para o histórico de suas locações.

Caso de uso 2: Manter registros da agência

Editar registro da filial. É a agência local onde o sistema está sendo executado.
O registro deve apresentar, no mínimo, os campos: CNPJ, insc. estadual, endereço, telefone, gerente responsável.
Para a primeira execução, você pode admitir uma agência default que pode ser alterada após o primeiro login.


Caso de uso 3: Exibir seguros 

&lt;NEW&gt;



Exibir tipos de seguros. É importante ressaltar que o seguro não é obrigatório; logo, nem todos os veículos precisam estar segurados. Considere, no mínimo,  dois tipos de cobertura: parcial  e total. Ao optar pelo seguro, o cliente deverá pagar uma taxa proporcional ao tipo de cobertura: 25% para a parcial e 50% para a total. Essa porcentagem incide sobre o custo total da locação.

Cobertura parcial : arranhões, amassados leves, acessórios danificados, etc.
Cobertura total: roubo e perda total do veículo.
Caso de uso 4: Manter registros dos clientes

O operador pode criar, editar e excluir registros dos clientes. Esses podem ser pessoas físicas ou jurídicas. Para o primeiro tipo assuma, no mínimo, os seguintes dados: CPF, nome, RG, data de nascimento, naturalidade, endereço, telefone para contato e e-mail. Para o segundo tipo assuma, no mínimo, os seguintes dados: CNPJ, razão social, nome de fantasia, inscrição estadual, endereço, telefone para contato e e-mail.

Caso de uso 5: Manter registros dos planos de locação

Criar, editar e excluir registros dos planos de locação. Tome, como exemplo, os seguintes planos para automóveis:
PLANO A: Celta, Pálio, Gol - 1.0 - Sem AC - 2P
PLANO B: Celta, Pálio, Gol, Sandero - 1.0 - AC - 2P/4P
PLANO C: Corsa, Prisma, Sandero - 1.4 - AC - DH - 2P/4P
PLANO D: Clio, Logan, Sandero, Fox - 1.6 - AC - DH - VE - 2P/4P
PLANO E: Corsa, Stilo, Prisma - 1.8 - AC - DH - VE - TE - 2P/4P
PLANO F: Corsa, Vectra, Astra - 2.0 - AC - DH - VE - TE - 4P
PLANO G: Corolla XEI, Civic XLS, Jetta - 1.8 - AC - DH - VE - TE - BC - GPS - 4P

Legenda:
AC - Ar Condicionado
DH - Direção Hidráulica
VE - Vidro Elétrico
TE - Trava Elétrica
AB - Air Bag
GPS - GPS
BC - Bancos de Couro
2P/4P - Número de Portas

E os seguintes planos para motocicletas:
PLANO A: Honda Biz, Honda CG, Yahama YBR, Traxx Fly - 125cc
PLANO B: Honda CBX, Yahaha XTZ - 250cc
PLANO C: Honda Shadow - 400 cc
PLANO D: Kawasaki ZX10  - 1000 cc


Caso de uso 6: Realizar locações

Um cliente (pessoa física ou jurídica) pode efetuar uma locação desde que não tenha débitos referentes à locações anteriores.
Esse ambiente deve registrar o nível do tanque do veículo no momento da entrega. Quando o veículo for devolvido, deve apresentar a mesma quantidade de combustível que tinha no momento da entrega. Mais detalhes, veja Caso de uso 7.
Os detalhes dos planos de locação já foram descritos. A locação deve apresentar um código exclusivo (da locação), data de entrega, data de devolução, código do(s) veículo(s) (pode ser o RENAVAM), código do cliente, nível do tanque do(s) veículo(s).
Uma pessoa física pode locar até 3 veículos. Para pessoa jurídica esse número aumenta para 10.
No fim, deve ser gerado um extrato para que o cliente pague antes de retirar o veículo.

Caso de uso 7: Saldar débitos dos clientes

Permite ao operador saldar débitos de um cliente. Dentro desse ambiente, é importante haver um link para uma nova locação considerando o mesmo cliente.

Caso de uso 8: Controlar Devoluções

Permite  um controle dos veículos que são devolvidos à locadora. Esse ambiente deve englobar a verificação do nível do tanque do veículo. Se o cliente entregar o veículo com o nível do tanque abaixo do valor estabelecido na locação, deve pagar uma taxa de reabastecimento.
Atrasos na devolução incorrem em multas proporcionais aos dias de atraso. Assuma como multa: dias\_de\_atraso x valor\_base\_da\_diária + (5% x dias\_de\_atraso x valor\_base\_da\_diária).
É necessário um campo para verificar se o veículo sofreu algum dano. Se o cliente não optou pelo seguro, deverá pagar uma multa proporcional ao plano e aos danos sofridos pelo veículo. Tome, como exemplo:
Plano A:
Arranhões: R$ 80,00
Amassados leves: R$ 180,00
Amassados graves: R$ 350,00
Roubo ou Perda Total: R$ 5.000,00

O cliente só pode devolver o(s) veículo(s) na agência onde locou.

Caso de uso 9: Manter registros dos funcionários

O operador pode criar, editar e excluir registros dos funcionários. Assuma, pelo menos, os cargos: gerente e locador.
Um registro de um funcionário deve conter, pelo menos: CPF, nome, RG, data de nascimento, naturalidade, endereço, telefone para contato e e-mail.
O registro do gerente não pode ser excluído.