import "./Home.css";
import { useNavigate, Link } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  const onFileChange = async (event) => {
    event.preventDefault(); // Evitar o comportamento padrão
    const file = event.target.files[0];

    if (file) {
      const formData = new FormData();
      formData.append("file", file);

      // Supondo que você tenha uma função para enviar o arquivo ao servidor
      try {
        const response = await fetch("http://localhost:8080/file/upload", {
          method: "POST",
          body: formData,
        });

        if (!response.ok) {
          throw new Error("Erro no envio do arquivo");
        }

        // Navegar após a confirmação de envio
        navigate("/generatemap");
      } catch (error) {
        console.error("Erro ao enviar o arquivo:", error);
      }
    }
  };

  return (
    <div className="containerHome">
      <div className="containerMain">
        <h1 className="newGraphsTitle">NOVO GRAFO</h1>
        <p className="newGraphText">
          <Link className="linkToInstructions" to={"/instructions"}>
            Leia aqui
          </Link>{" "}
          as instruções para gerar um novo grafo através de seus dados em XML
        </p>
        <div className="containerNewGraphButton">
          <form encType="multipart/form-data">
            <input
              type="file"
              id="file"
              name="file"
              onChange={onFileChange}
              style={{ display: "none" }}
            />
            <label htmlFor="file" className="generateNewGraphButton">
              Gerar grafo
            </label>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Home;
