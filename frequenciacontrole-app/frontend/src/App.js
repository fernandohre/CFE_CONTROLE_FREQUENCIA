import React, { Component } from 'react';
import './App.css';




class App extends Component {

  constructor(props){
    super(props);
    this.state={
      title: 'Controle de frequencia',
      act: 0,
      index: '',
      datas: []
    }
  } 

  buildList = (data) => {
    console.log(data, null, '/t');
  }

  componentDidMount(){
    fetch('http://localhost:8080/alunos')
      .then(res => res.json())
      .then(json => {
        this.setState({
          datas: json
        })
      });
  }

  

  fSubmit = (e) =>{
    e.preventDefault();
    console.log('try');

    let datas = this.state.datas;
    let nomeAluno = this.refs.nomeAluno.value;

    if(this.state.act === 0){   //new
      console.log("Adicionando primeiro...");
      let data = {
        nomeAluno
      }
      datas.push(data);
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
    this.refs.name.focus();
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

  render() {
    let datas = this.state.datas;
    return (
      <div className="App">
        <h2>{this.state.title}</h2>
        <form ref="myForm" className="myForm">
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
            </li>
          )}
        </pre>
      </div>
    );
  }
}

export default App;
