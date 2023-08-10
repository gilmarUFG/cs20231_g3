import App from '../App';

export default function IndexPage() {
    return (

        <div className="ProjectPage-body">
        
            <div className="ProjectPage-container">
                
                <div className="ProjectPage-title">
                    <h1>Nome do Projeto</h1>
                    <h2>Nome do Autor</h2>
                </div>

                <div className="ProjectPage-Image">
                    <img src="https://picsum.photos/200/300" alt="Imagem do Projeto" />
                </div>

                <div className="ProjectPage-Info">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ullamcorper consectetur orci, ut rhoncus turpis accumsan sit amet.</p>
                    <button>Apoiar</button>
                </div>
            </div>
        </div>

    )
}
