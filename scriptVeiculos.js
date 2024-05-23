var veiculos = [
    {
        'placa':'1234ABC',
        'cidade': 'São Carlos',
        'estado': 'SP',
        'tipo': 'Urbano',
        'marca': 'Mercedes-Benz',
        'modelo': 'VX01',
        'ano': 2022,
        'combustiveis': ['Gasolina'],
        'cor': 'cinza',
        'velocidade_maxima': 100,
    },
    {
        'placa':'1564ABC',
        'cidade': 'São Paulo',
        'estado': 'SP',
        'tipo': 'Caminhão Pesado',
        'marca': 'Mercedes-Benz',
        'modelo': 'VX02',
        'ano': 2020,
        'combustiveis': ['Gasolina', 'GNV'],
        'cor': 'cinza',
        'velocidade_maxima': 100,
    }
]


function find(array, placa){
    //verifica se o código já existe e retorna uma mensagem
    for(var i in array){
        if(array[i].placa == placa){
            return i
        }
    }
    return -1
}

function getVeiculos(){
    let strVetorArmazenado = localStorage.getItem("vetorVeiculos");
    var veiculosFiltrados = JSON.parse(strVetorArmazenado);
    if (veiculosFiltrados == null){
        return [];
    }
    return veiculosFiltrados
}

function btnInserir(){
    veiculosFiltrados = getVeiculos()

    var placa = document.getElementById("iptPlaca").value;
    var index = find(veiculosFiltrados, placa)
    console.log(index)
    

    if(index == -1){
        var cidade = document.getElementById("iptCidade").value;
        var estado = document.getElementById("iptEstado").value;
        var marca = document.getElementById("iptMarca").value;
        var modelo = document.getElementById("iptModelo").value;
        var ano = document.getElementById("iptAno").value;
        var cor = document.getElementById("iptCor").value;
        var velocidade = document.getElementById("iptVelocidade_maxima").value;

        var tipo = document.getElementById("iptTipo");
        var selectTipo = tipo.options[tipo.selectedIndex].text;

        var combustiveis = [];
        for (var option of document.getElementById('iptCombustiveis').options)
        {
            if (option.selected) {
                combustiveis.push(option.value);
            }
        }

        // Nova mercadoria
        var obj = {
            'placa': placa,
            'cidade': cidade,
            'estado': estado,
            'tipo': selectTipo,
            'marca': marca,
            'modelo': modelo,
            'ano': ano,
            'combustiveis': combustiveis,
            'cor': cor,
            'velocidade_maxima': velocidade,
        }

        veiculosFiltrados.push(obj)
        let stringVetor = JSON.stringify(veiculosFiltrados);
        localStorage.setItem("vetorVeiculos",stringVetor);
        console.log(veiculosFiltrados)
        alert("Cadastrado com sucesso!")

        
        
    }
    else{
        alert("Placa já cadastrada!")
    }

    window.location.reload();

}

function btnAlterar(){
    var placa = document.getElementById("iptPlaca").value;
    var veiculosFiltrados = veiculos
    var index = find(veiculosFiltrados, placa)
    

    if(index != -1){
        var cidade = document.getElementById("iptCidade").value;
        var estado = document.getElementById("iptEstado").value;
        var marca = document.getElementById("iptMarca").value;
        var modelo = document.getElementById("iptModelo").value;
        var ano = document.getElementById("iptAno").value;
        var cor = document.getElementById("iptCor").value;
        var velocidade = document.getElementById("iptVelocidade_maxima").value;
        
        var tipo = document.getElementById("iptTipo");
        var selectTipo = tipo.options[tipo.selectedIndex].text;

        var tipo = document.getElementById("iptTipo");
        var selectTipo = tipo.options[tipo.selectedIndex].text;

        var combustiveis = [];
        for (var option of document.getElementById('iptCombustiveis').options)
        {
            if (option.selected) {
                combustiveis.push(option.value);
            }
        }

        // Nova mercadoria
        var obj = {
            'placa': placa,
            'cidade': cidade,
            'estado': estado,
            'tipo': selectTipo,
            'marca': marca,
            'modelo': modelo,
            'ano': ano,
            'combustiveis': combustiveis,
            'cor': cor,
            'velocidade_maxima': velocidade,
        }

        

        veiculosFiltrados.splice(index, 1, obj)
        console.log(veiculosFiltrados)
    }
    else{
        alert("Não encontrado!")
    }
}

function btnExcluir(){
    var veiculosFiltrados = veiculos
    var placa = document.getElementById("iptPlacaExcluir").value
    var index = find(veiculosFiltrados, placa)
    if(index==-1){
    	alert("Placa não encontrada!")
    }else{
        console.log(veiculosFiltrados)
        veiculosFiltrados.splice(index, 1)
        console.log(veiculosFiltrados)
    }
}

function btnListarUm(){
    var veiculosFiltrados = veiculos
    var placa = document.getElementById("iptPlacaListarUm").value
    var index = find(veiculosFiltrados, placa)
    if(index==-1){
    	alert("Placa não encontrada!")
    }else{
	document.getElementById("conteudoListagem").innerHTML =
        `
        <br>
        <div class="card" style="background-color: #5d85b8;color:white;">
            <div class="card-header">
                Transporte
            </div>
            <div class="card-body">
              <h5 class="card-title">Placa: ${veiculosFiltrados[index].placa}</h5>
              <p class="card-text">
                <hr>Localização:<br>
                &emsp;Cidade: ${veiculosFiltrados[index].cidade} <br>
                &emsp;Estado: ${veiculosFiltrados[index].estado} <br>
                <hr>Caracteristica:<br>
                &emsp;Tipo: ${veiculosFiltrados[index].tipo} <br>
                &emsp;Marca: ${veiculosFiltrados[index].marca} <br>
                &emsp;Modelo: ${veiculosFiltrados[index].modelo} <br>
                &emsp;Ano: ${veiculosFiltrados[index].ano} <br>
                &emsp;Cor: ${veiculosFiltrados[index].cor}<br>
                &emsp;Velocidade Máxima: ${veiculosFiltrados[index].cor}<br>
            </p>
            </div>
        </div>
        `
    }
    document.getElementById("iptPlacaListarUm").value = ""
    console.log(index)
}

function btnListarTodos(){
    var veiculosFiltrados = getVeiculos()
    document.getElementById("conteudoListagem").innerHTML = ''
    for(var x in veiculosFiltrados){
        console.log(x)
        //document.getElementById("conteudoListagem").innerHTML += veiculosFiltrados[x].descricao;
        document.getElementById("conteudoListagem").innerHTML +=
        `
        <br>
        <div class="card" style="background-color: #5d85b8;color:white;">
            <div class="card-header">
                Veiculo
            </div>
            <div class="card-body">
              <h5 class="card-title">Placa: ${veiculosFiltrados[x].placa}</h5>
              <p class="card-text">
                <hr>Localização:<br>
                &emsp;Cidade: ${veiculosFiltrados[x].cidade} <br>
                &emsp;Estado: ${veiculosFiltrados[x].estado} <br>
                <hr>Caracteristica:<br>
                &emsp;Tipo: ${veiculosFiltrados[x].tipo} <br>
                &emsp;Marca: ${veiculosFiltrados[x].marca} <br>
                &emsp;Modelo: ${veiculosFiltrados[x].modelo} <br>
                &emsp;Ano: ${veiculosFiltrados[x].ano} <br>
                &emsp;Cor: ${veiculosFiltrados[x].cor}<br>
                &emsp;Velocidade Máxima: ${veiculosFiltrados[x].cor}<br>
            </p>
            </div>
        </div>
        `
    }
}