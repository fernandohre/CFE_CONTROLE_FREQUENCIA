import React, { Component } from 'react';
import './App.css';

import Select from 'react-select'

const options = []

class App extends Component {

  constructor(props){
    super(props);
    this.state={
      title: 'Controle de frequencia',
      act: 0,
      index: '',
      datas: [],
      turmas: []
    }
  }

  componentDidMount(){
    //Obtém alunos
    fetch('http://localhost:8080/alunos')
      .then(res => res.json())
      .then(json => {
        this.setState({
          datas: json
        })
      });

    //Obtém turmas
    fetch('http://localhost:8080/turmas')
      .then(res => res.json())
      .then(json => {
        this.setState({
          turmas: json
        })
        console.log("json: 0", json);

        json.forEach((item) => {
          console.log(item);
          options.push({
            value: item.id,
            label: item.descricao
          })
        })
      });
    
    
  }

  fSubmit = (e) =>{
    e.preventDefault();

    let datas = this.state.datas;
    let nomeAluno = this.refs.nomeAluno.value;
    let index = this.state.index;

    let req = {
      nome: nomeAluno
    }

    if(this.state.act === 0){   //new
      console.log("Adicionando na lista");

      fetch('http://localhost:8080/alunos', 
          { method: 'post', 
            headers: {
              'Content-Type':'application/json'
            }, 
            body: JSON.stringify(req)
          })
      .then(res => {
        res.json()
      })
      .catch((error) => {
        console.log("Falha ao salvar: ", error);
      })
      
      datas.push({
        id: index + 1,
        nome: nomeAluno
      })
    }else{                      //update
      console.log("atualizando lista...");
      let index = this.state.index;
      debugger;
      datas[index].nome = nomeAluno;
    }    

    this.setState({
      datas: datas,
      act: 0
    });

    this.refs.myForm.reset();
  }

  fRemove = (i) => {
    let datas = this.state.datas;
    datas.splice(i,1);
    this.setState({
      datas: datas
    });

    this.refs.myForm.reset();
    this.refs.nomeAluno.focus();
  }

  fEdit = (i) => {
    let data = this.state.datas[i];
    debugger;
    this.refs.nomeAluno.value = data.nome;

    this.setState({
      act: 1,
      index: i
    });

    this.refs.nomeAluno.focus();
  }
  
  fMarcarPresenca = (i) => {

  }
  
  render() {
    let datas = this.state.datas;
    return (
      <div className="App">
        <h2>{this.state.title}</h2>
        <form ref="myForm" className="myForm">
          <Select options={options} placeholder="Selecione uma turma"/>
          {/*<input type="text" ref="name" placeholder="Selecione a turma" className="formField" />*/}
          <input type="text" ref="nomeAluno" placeholder="Nome do aluno" className="formField" />
          <button onClick={(e)=>this.fSubmit(e)} className="myButton">Salvar </button>
        </form>
        <pre>
          {datas.map((data, i) =>
            <li key={i} className="myList">
              {i+1}. {data.nome}
              <button onClick={()=>this.fRemove(i)} className="myListButton">Remover </button>
              <button onClick={()=>this.fEdit(i)} className="myListButton">Editar </button>
              <button onClick={()=>this.fMarcarPresenca(i)} className="myListButton">Marcar Presença</button>
            </li>
          )}
        </pre>
      </div>
    );
  }
}

export default App;
