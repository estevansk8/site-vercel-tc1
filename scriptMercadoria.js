var mercadorias = [
    {
        'codigo': 01,
        'descricao': 'Mercadoria Nova',
        'validade': '29/08/2022',
        'peso': '100kg',
        'altura': '1m',
        'largura': '0.2m',
        'volume': '0.5m3',
        'fragilidade': 'segura'
    },
    {
        'codigo': 02,
        'descricao': 'Mercadoria Vewlha',
        'validade': '29/08/2022',
        'peso': '100kg',
        'altura': '1m',
        'largura': '0.2m',
        'volume': '0.6m3',
        'fragilidade': 'segura'
    },
];

// Atualizado com localstorage
function btnIncluir(){
    //precisa verificar se já existe
    var codigo = document.getElementById("iptCodigo").value;
    var index = getIndex(codigo)
    console.log(index)
    

    if(index == -1){
        var descricao = document.getElementById("iptDescricao").value;
        var validade = document.getElementById("iptDataValidade").value;
        var peso = document.getElementById("iptPeso").value;
        var altura = document.getElementById("iptAltura").value;
        var largura = document.getElementById("iptLargura").value;
        var volume = document.getElementById("iptVolume").value;
        
        var fragilidade = document.getElementById("fragilidade");
        var selectfragilidade = fragilidade.options[fragilidade.selectedIndex].text;

        // Nova mercadoria
        var obj = {
            'codigo': codigo,
            'descricao': descricao,
            'validade': validade,
            'peso': peso,
            'altura': altura,
            'largura': largura,
            'volume': volume,
            'fragilidade': selectfragilidade
        }

        mercadorias.push(obj)
        let stringVetor = JSON.stringify(mercadorias);
        localStorage.setItem("vetorMercadorias",stringVetor);
        console.log(mercadorias)
        alert("Cadastrado com sucesso!")


    }
    else{
        alert("Código já cadastrado!")
    }
    document.getElementById("iptDescricao").value = ''
    document.getElementById("iptDataValidade").value = ''
    document.getElementById("iptPeso").value = ''
    document.getElementById("iptAltura").value = ''
    document.getElementById("iptLargura").value = ''
    document.getElementById("iptVolume").value = ''
}

// Atualizado com localstorage
function btnAlterar(){
    //precisa verificar se já existe
    var codigo = document.getElementById("iptCodigo").value;
    var index = getIndex(codigo)
    console.log(index)
    

    if(index != -1){
        var descricao = document.getElementById("iptDescricao").value;
        var validade = document.getElementById("iptDataValidade").value;
        var peso = document.getElementById("iptPeso").value;
        var altura = document.getElementById("iptAltura").value;
        var largura = document.getElementById("iptLargura").value;
        var volume = document.getElementById("iptVolume").value;
        
        var fragilidade = document.getElementById("fragilidade");
        var selectfragilidade = fragilidade.options[fragilidade.selectedIndex].text;

        // Nova mercadoria
        var obj = {
            'codigo': codigo,
            'descricao': descricao,
            'validade': validade,
            'peso': peso,
            'altura': altura,
            'largura': largura,
            'volume': volume,
            'fragilidade': selectfragilidade
        }

        mercadorias.splice(index, 1, obj)
        let stringVetor = JSON.stringify(mercadorias);
        localStorage.setItem("vetorMercadorias",stringVetor);
        alert("Alterado com sucesso!")
    }
    else{
        alert("Código não encontrado!")
    }
    console.log(index)
}

// Atualizado com localstorage
function getIndex(codigo){
    let strVetorArmazenado = localStorage.getItem("vetorMercadorias");
    var mercadoriasFiltradas = JSON.parse(strVetorArmazenado);
    for(var i in mercadoriasFiltradas){
        if(mercadoriasFiltradas[i].codigo == codigo){
            return i
        }
    }
    return -1
}

// Atualizado com localstorage
function btnExcluir(){
    let strVetorArmazenado = localStorage.getItem("vetorMercadorias");
    var mercadoriasFiltradas = JSON.parse(strVetorArmazenado);
    var element = document.getElementById("iptCodigoExcluir")
    var codigo = element.value;
    element.value = ""
    var index = getIndex(codigo)
    if(index == -1){
        alert("Not Found")
    }else{
        console.log(index)
        mercadoriasFiltradas.splice(index, 1)
        let stringVetor = JSON.stringify(mercadoriasFiltradas);
        localStorage.setItem("vetorMercadorias",stringVetor);
        alert("Excluído com sucesso!")
    }
}

function listar_todos(array, campo, valor){
    var newArray = []
    for(var i in array){
        if(array[i][campo] == valor){
            newArray.push(array[i])
        }
        
    }

    return newArray
}

// Atualizado com localstorage
function btnListar_um(){
    
    var element = document.getElementById("iptCodigoUm")
    var codigo = element.value;
    element.value = ""
    var index = getIndex(codigo)
    if(index == -1){
        alert("Not Found")
    }else{
        document.getElementById("conteudoListagemUm").innerHTML +=
        `
        <br>
        <div class="card" style="background-color: #5d85b8;color:white;">
            <div class="card-header">
                Mercadoria - #${mercadorias[index].codigo}
            </div>
            <div class="card-body">
              <h5 class="card-title">${mercadorias[index].descricao}</h5>
              <p class="card-text">
                <hr>Medidas:<br>
                &emsp;Peso: ${mercadorias[index].peso} <br>
                &emsp;Altura: ${mercadorias[index].altura} <br>
                &emsp;Largura: ${mercadorias[index].largura} <br>
                &emsp;Volume: ${mercadorias[index].volume} <br>
                &emsp;Fragilidade: ${mercadorias[index].fragilidade}
            </p>
            </div>

            <div class="card-footer" style="color:rgb(216, 216, 216);">
                Valido até: ${mercadorias[index].validade}
            </div>
        </div>
        `
    }
}

function verifica(array, codigo){
    //verifica se o código já existe e retorna uma mensagem
    for(var i in array){
        if(array[i]['codigo'] == codigo){
            return true
        }
    }
    return false
}

// Atualizado com localstorage
// FUNÇÕES DE CLICK
function btnListarTodos(){
    // var mercadoriasFiltradas = listar_todos(mercadorias, "volume", "0.5m3")
    let strVetorArmazenado = localStorage.getItem("vetorMercadorias");
    var mercadoriasFiltradas = JSON.parse(strVetorArmazenado);

    document.getElementById("conteudoListagem").innerHTML = ''
    for(var x in mercadoriasFiltradas){
        console.log(x)
        //document.getElementById("conteudoListagem").innerHTML += mercadoriasFiltradas[x].descricao;
        document.getElementById("conteudoListagem").innerHTML +=
        `
        <br>
        <div class="card" style="background-color: #5d85b8;color:white;">
            <div class="card-header">
                Mercadoria - #${mercadoriasFiltradas[x].codigo}
            </div>
            <div class="card-body">
              <h5 class="card-title">${mercadoriasFiltradas[x].descricao}</h5>
              <p class="card-text">
                <hr>Medidas:<br>
                &emsp;Peso: ${mercadoriasFiltradas[x].peso} <br>
                &emsp;Altura: ${mercadoriasFiltradas[x].altura} <br>
                &emsp;Largura: ${mercadoriasFiltradas[x].largura} <br>
                &emsp;Volume: ${mercadoriasFiltradas[x].volume} <br>
                &emsp;Fragilidade: ${mercadoriasFiltradas[x].fragilidade}
            </p>
            </div>

            <div class="card-footer" style="color:rgb(216, 216, 216);">
                Valido até: ${mercadoriasFiltradas[x].validade}
            </div>
        </div>
        `
    }
}
