$(document).ready(function(){

    // Find some field on some array
    function find(array, field, placa, unique){
        multiple = []
        for(var i in array){
            if(array[i][field] == placa){
                if(unique){
                    return i
                }else{
                    multiple.push(array[i])
                }
                
            }
        }
        if (!unique){
            return multiple
        }
        return -1
    }

    // Set the transports on select -> Excluir
    function setupTransportes(transportes, field){
        var select = document.getElementById(field)
        for(var x in transportes){
            var option = document.createElement('option')
            option.setAttribute('value', x)
            var text = document.createTextNode(transportes[x].placa + ' - ' +transportes[x].codigo + ' - ' + transportes[x].data_inicio)
            option.appendChild(text)
            select.appendChild(option)
        }
    }

    // Set the vehicles on select
    function setupPlacas(vehicles){
        var select = document.getElementById('iptPlaca')
        for(var x in vehicles){
            var option = document.createElement('option')
            option.setAttribute('value', vehicles[x].placa)
            var text = document.createTextNode(vehicles[x].placa)
            option.appendChild(text)
            select.appendChild(option)
        }
    }

    // Set the mercadorias on select
    function setupMercadorias(mercadorias){
        var select = document.getElementById('iptCodigo')
        for(var x in mercadorias){
            var option = document.createElement('option')
            option.setAttribute('value', mercadorias[x].codigo)
            var text = document.createTextNode(mercadorias[x].codigo)
            option.appendChild(text)
            select.appendChild(option)
        }
    }

    // Return veiculos from localStorage
    function loadVeiculos(){
        let strVetorArmazenado = localStorage.getItem("vetorVeiculos");
        var veiculosFiltrados = JSON.parse(strVetorArmazenado);
        if (veiculosFiltrados == null){
            return [];
        }
        return veiculosFiltrados
    }

    // Return mercadorias from localStorage
    function loadMercadorias(){
        let strVetorArmazenado = localStorage.getItem("vetorMercadorias");
        var mercadoriasResgatadas = JSON.parse(strVetorArmazenado);
        if (mercadoriasResgatadas == null){
            return [];
        }
        return mercadoriasResgatadas
    }

    // Return transportes from localStorage
    function loadTransportes(){
        let strVetorArmazenado = localStorage.getItem("vetorTransportes");
        var transportesRetornados = JSON.parse(strVetorArmazenado);
        if (transportesRetornados == null){
            return [];
        }
        return transportesRetornados
    }

    // When the user choose some value on plate
    $('#iptPlaca').on('change', function() {
        $("#iptPlaca option[value='None']").remove();
        if(this.value != 'None'){
            var index = find(veiculos, 'placa', this.value, true)
            $('#iptCidade').show()
            $('#iptEstado').show()
            $('#iptCidade').val(veiculos[index].cidade)
            $('#iptEstado').val(veiculos[index].estado)
            console.log( this.value );
        }
        
    });

    // Remove the first option
    $('#iptTransporteAlterar').on('change', function() {
        $("#iptTransporteAlterar option[value='None']").remove(); 
        var transportes = loadTransportes()
        var field = $('#iptTransporteAlterar').find(":selected").val();
        console.log(transportes[field])
        var descendentes = $("#formAlterar").find(".canChange")
        descendentes.attr('disabled', false)

        $("#iptPlacaAlterar").val(transportes[field].placa)
        $("#iptCidadeAlterar").val(transportes[field].placa_cidade)
        $("#iptEstadoAlterar").val(transportes[field].placa_estado)

        $("#iptCodigoAlterar").val(transportes[field].codigo)

        $("#iptDataInicioAlterar").val(transportes[field].data_inicio)
        $("#iptDataTerminoAlterar").val(transportes[field].data_termino)

        $("#iptCidadeInicioAlterar").val(transportes[field].trecho_inicio)
        $("#iptCidadeTerminoAlterar").val(transportes[field].trecho_termino)
        $("#iptQuilometrosAlterar").val(transportes[field].trecho_quilometros)

        $("#alterarTransporte").attr("disabled", false)
    });

    // Alterar transport
    $('#alterarTransporte').click(function(){
        var transportes = loadTransportes()
        var field = $('#iptTransporteAlterar').find(":selected").val();


        var plate = $('#iptPlacaAlterar').val()
        var codigo = $('#iptCodigoAlterar').val()
        var data_inicio = $('#iptDataInicioAlterar').val()
        var data_termino = $('#iptDataTerminoAlterar').val()
        var cidade_inicio = $('#iptCidadeInicioAlterar').val()
        var cidade_termino = $('#iptCidadeTerminoAlterar').val()
        var quilometros = $('#iptQuilometrosAlterar').val()
        var placa_cidade = $('#iptCidadeAlterar').val()
        var placa_estado = $('#iptEstadoAlterar').val()
        var transporte = {
            'placa': plate,
            'placa_cidade': placa_cidade,
            'placa_estado': placa_estado,
            'codigo': codigo,
            'data_inicio': data_inicio,
            'data_termino': data_termino,
            'trecho_inicio': cidade_inicio,
            'trecho_termino': cidade_termino,
            'trecho_quilometros': quilometros
        }
        console.log(transporte)
        transportes.splice(field, 1, transporte)
        let stringVetor = JSON.stringify(transportes);
        localStorage.setItem("vetorTransportes", stringVetor);
        alert("Alterado com sucesso!")
        window.location.reload();
    })

    // Remove the first option
    $('#iptCodigo').on('change', function() {
        $("#iptCodigo option[value='None']").remove();
    });

    // Remove the first option
    $('#iptTransporteListarUm').on('change', function() {
        $("#iptTransporteListarUm option[value='None']").remove();

        var transportes = loadTransportes()
        var index = $('#iptTransporteListarUm').find(":selected").val();

        var conteudo = document.getElementById("conteudoListagemAlterar")
        conteudo.innerHTML = ''
        var br = document.createElement('br')
        var div = document.createElement('div')
        div.setAttribute('class', 'card')
        div.setAttribute('style', 'background-color: #5d85b8;color:white;')
        
            var divheader = document.createElement('div')
            divheader.setAttribute('class', 'card-header')
                var transport = document.createTextNode('Transporte')
            divheader.appendChild(transport)
        
        div.appendChild(divheader)
        
            var divbody = document.createElement('div')
            divbody.setAttribute('class', 'card-body')
                
                var title = document.createTextNode(`Placa: ${transportes[index].placa} - Código: ${transportes[index].codigo}`)
                var h5 = document.createElement('h5')
                h5.appendChild(title)
            
            divbody.appendChild(h5)

                var p = document.createElement('p')
                p.setAttribute('class', 'card-text')

                p.appendChild(document.createElement('hr'))
                
                p.appendChild(document.createTextNode('Veiculo'))
                
                p.appendChild(document.createElement('br'))
                p.appendChild(document.createTextNode(` Cidade Veículo: ${transportes[index].placa_cidade}`))
                p.appendChild(document.createElement('br'))
                p.appendChild(document.createTextNode(`Estado Veículo: ${transportes[index].placa_estado}`))
                p.appendChild(document.createElement('br'))

                p.appendChild(document.createElement('hr'))

                p.appendChild(document.createTextNode('Tempo Estimado'))
                p.appendChild(document.createElement('br'))
                p.appendChild(document.createTextNode(`Data Início: ${transportes[index].data_inicio}`))
                p.appendChild(document.createElement('br'))
                p.appendChild(document.createTextNode(`Data Fim: ${transportes[index].data_termino}`))
                p.appendChild(document.createElement('br'))

                p.appendChild(document.createElement('hr'))

                p.appendChild(document.createTextNode('Trecho'))
                p.appendChild(document.createElement('br'))
                p.appendChild(document.createTextNode(`Cidade Inicio: ${transportes[index].trecho_inicio}`))
                p.appendChild(document.createElement('br'))
                p.appendChild(document.createTextNode(`Cidade Término: ${transportes[index].trecho_termino}`))
                p.appendChild(document.createElement('br'))
                p.appendChild(document.createTextNode(`Quilometros: ${transportes[index].trecho_quilometros}`))
                p.appendChild(document.createElement('br'))

                p.appendChild(document.createElement('hr'))
            
            divbody.appendChild(p)

        div.appendChild(divbody)

        
        conteudo.appendChild(div)
                    
    });

    // Insert transporte
    $('#inserirTransporte').click(function(){
        var plate = $('#iptPlaca').val()
        var codigo = $('#iptCodigo').val()
        var data_inicio = $('#iptDataInicio').val()
        var data_termino = $('#iptDataTermino').val()
        var cidade_inicio = $('#iptCidadeInicio').val()
        var cidade_termino = $('#iptCidadeTermino').val()
        var quilometros = $('#iptQuilometros').val()
        
        if(plate == 'None' || codigo == 'None' || data_inicio == null || data_termino == null || cidade_inicio == null || cidade_termino == null || quilometros == null){
            alert('Informe todos os campos!')
        }else{
            var placa_cidade = $('#iptCidade').val()
            var placa_estado = $('#iptEstado').val()
            var transporte = {
                'placa': plate,
                'placa_cidade': placa_cidade,
                'placa_estado': placa_estado,
                'codigo': codigo,
                'data_inicio': data_inicio,
                'data_termino': data_termino,
                'trecho_inicio': cidade_inicio,
                'trecho_termino': cidade_termino,
                'trecho_quilometros': quilometros
            }
            var transportes = loadTransportes()
            transportes.push(transporte)
            let stringVetor = JSON.stringify(transportes);
            localStorage.setItem("vetorTransportes",stringVetor);
            alert("Transporte Inserido com sucesso!")
        }
        window.location.reload();
    })

    // Search all
    $('#pesquisarTodos').click(function(){
        var transportes = loadTransportes()
        var field = $('#iptSearch').find(":selected").val();
        if(field != 'Todos'){
            var search = $('#iptSearchText').val();
            if(search == ''){
                alert('Informe algum campo de pesquisa!')
            }else{
                var transportes = find(transportes, field, search, false)
                console.log(transportes)
            }
        }

        if(transportes.length == 0){
            var div = document.createElement('div')
            var br = document.createElement('br')
            div.appendChild(br)
            var h2 = document.createElement('h2')
            var txt = document.createTextNode('Nada Encontrado, tente mudar a filtragem!')
            h2.appendChild(txt)
            div.appendChild(h2)
            div.appendChild(br)

        }else{
            var conteudo = document.getElementById("conteudoListagem")
            conteudo.innerHTML = ''
            for(index in transportes){
                var br = document.createElement('br')
                var div = document.createElement('div')
                div.setAttribute('class', 'card')
                div.setAttribute('style', 'background-color: #5d85b8;color:white;')
                
                    var divheader = document.createElement('div')
                    divheader.setAttribute('class', 'card-header')
                        var transport = document.createTextNode('Transporte')
                    divheader.appendChild(transport)
                
                div.appendChild(divheader)
                
                    var divbody = document.createElement('div')
                    divbody.setAttribute('class', 'card-body')
                        
                        var title = document.createTextNode(`Placa: ${transportes[index].placa} - Código: ${transportes[index].codigo}`)
                        var h5 = document.createElement('h5')
                        h5.appendChild(title)
                    
                    divbody.appendChild(h5)

                        var p = document.createElement('p')
                        p.setAttribute('class', 'card-text')

                        p.appendChild(document.createElement('hr'))
                        
                        p.appendChild(document.createTextNode('Veiculo'))
                        
                        p.appendChild(document.createElement('br'))
                        p.appendChild(document.createTextNode(` Cidade Veículo: ${transportes[index].placa_cidade}`))
                        p.appendChild(document.createElement('br'))
                        p.appendChild(document.createTextNode(`Estado Veículo: ${transportes[index].placa_estado}`))
                        p.appendChild(document.createElement('br'))

                        p.appendChild(document.createElement('hr'))

                        p.appendChild(document.createTextNode('Tempo Estimado'))
                        p.appendChild(document.createElement('br'))
                        p.appendChild(document.createTextNode(`Data Início: ${transportes[index].data_inicio}`))
                        p.appendChild(document.createElement('br'))
                        p.appendChild(document.createTextNode(`Data Fim: ${transportes[index].data_termino}`))
                        p.appendChild(document.createElement('br'))

                        p.appendChild(document.createElement('hr'))

                        p.appendChild(document.createTextNode('Trecho'))
                        p.appendChild(document.createElement('br'))
                        p.appendChild(document.createTextNode(`Cidade Inicio: ${transportes[index].trecho_inicio}`))
                        p.appendChild(document.createElement('br'))
                        p.appendChild(document.createTextNode(`Cidade Término: ${transportes[index].trecho_termino}`))
                        p.appendChild(document.createElement('br'))
                        p.appendChild(document.createTextNode(`Quilometros: ${transportes[index].trecho_quilometros}`))
                        p.appendChild(document.createElement('br'))

                        p.appendChild(document.createElement('hr'))
                    
                    divbody.appendChild(p)

                div.appendChild(divbody)

                
                conteudo.appendChild(div)
                    
            }
        }
        
        console.log(field, search)
        //var filtred = find(veiculos, 'placa', this.value, true)
    })

    // Excluir Transporte
    $('#excluirTransporte').click(function(){
        var transportes = loadTransportes()
        var field = $('#iptTransporte').find(":selected").val();
        console.log(transportes[field])

        transportes.splice(field, 1)
        let stringVetor = JSON.stringify(transportes);
        localStorage.setItem("vetorTransportes", stringVetor);
        alert("Excluído com sucesso!")
        window.location.reload();
    })

    // INIT
    console.log('Loading Veiculos...')
    
    var href = document.location.href;
    var lastPathSegment = href.substr(href.lastIndexOf('/') + 1);
    var veiculos = loadVeiculos()
    var mercadorias = loadMercadorias()
    var transportes = loadTransportes()

    if(lastPathSegment == 'transporte.html'){
        setupPlacas(veiculos)
        setupMercadorias(mercadorias)
        $('#iptCidade').hide()
        $('#iptEstado').hide()
    }else if(lastPathSegment == 'excluir.html'){
        setupTransportes(transportes, "iptTransporte")
    }else if(lastPathSegment == 'alterar.html'){
        setupTransportes(transportes, "iptTransporteAlterar")
    }else if(lastPathSegment == 'listarum.html'){
        setupTransportes(transportes, "iptTransporteListarUm")
    }
    
    

    

})


