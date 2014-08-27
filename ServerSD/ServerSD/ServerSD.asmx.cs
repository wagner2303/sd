using AutoMapper;
using ServerSD.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ServerSD
{
    /// <summary>
    /// Summary description for ServerSD
    /// </summary>
    [WebService(Namespace = "http://server.sd.ufmt.br/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ServerSD : System.Web.Services.WebService
    {
        private ServerModel db = new ServerModel();

        [WebMethod]
        public Models.ServiceModel.ItemBuscaNome[] BuscaArquivo(string termo)
        {
            var resultado_parcial = db.ItemBuscaNome.Include("DescricaoArquivo").Where(x => x.nome.Contains(termo));
            var resultado_final = Mapper.Map<IEnumerable<Models.ServiceModel.ItemBuscaNome>>(resultado_parcial);
            return resultado_final.ToArray();
        }

        [WebMethod]
        public Models.ServiceModel.ClienteD[] getClientesD(Models.ServiceModel.DescricaoArquivo descricao)
        {
            if (db.DescricaoArquivo.Find(descricao.md5Arquivo) != null)
            {
                var resultado_parcial = db.DescricaoArquivo.Find(descricao.md5Arquivo).ClienteD;
                var resultado_final = Mapper.Map<IEnumerable<Models.ServiceModel.ClienteD>>(resultado_parcial);
                return resultado_final.ToArray();
            }
            return null;
        }
        [WebMethod]
        public bool publicaArquivo(Models.ServiceModel.ItemBuscaNome arquivo)
        {
            var endereco = Context.Request.UserHostAddress;
            DescricaoArquivo da = null;
            ItemBuscaNome ibn = null;
            ClienteD cd = null;
            try
            {
                //Verifica se a Descrição do arquivo está cadastrada
                if(db.DescricaoArquivo.Find(arquivo.DescricaoArquivo.md5Arquivo) == null)
                {
                    da = new DescricaoArquivo();
                    da.md5Arquivo = arquivo.DescricaoArquivo.md5Arquivo;
                    da.tamanho = arquivo.DescricaoArquivo.tamanho;
                    db.DescricaoArquivo.Add(da);
                    db.SaveChanges();
                }
                else
                {
                    da = db.DescricaoArquivo.Find(arquivo.DescricaoArquivo.md5Arquivo);
                }
               
                //Verifica se já existe um item de busca com o mesmo nome e a mesma descrição
                if (!db.ItemBuscaNome.Any(x => x.nome == arquivo.nome && x.md5Arquivo == da.md5Arquivo))
                {
                    ibn = new ItemBuscaNome();
                    ibn.DescricaoArquivo = da;
                    ibn.nome = arquivo.nome;
                    db.ItemBuscaNome.Add(ibn);
                }
                else
                {
                    ibn = db.ItemBuscaNome.First(x => x.nome == arquivo.nome && x.md5Arquivo == da.md5Arquivo);
                }

                //Verifica se o cliente já está cadastrado
                if (db.ClienteD.Find(endereco) == null)
                {
                    cd = new ClienteD();
                    cd.endereco = endereco;
                    db.ClienteD.Add(cd);
                }
                else
                {
                    cd = db.ClienteD.Find(endereco);
                }

                db.SaveChanges();

                //Verifica se o cliente já possui o arquivo
                if(!db.ClienteD.Find(endereco).DescricaoArquivo.Contains(da))
                {
                    db.ClienteD.Find(endereco).DescricaoArquivo.Add(da);
                }
                db.SaveChanges();
            }
            //Se não conseguir gravar no banco retorna false
            catch (Exception e)
            {
                return false;
            }

            return true;
        }
        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
