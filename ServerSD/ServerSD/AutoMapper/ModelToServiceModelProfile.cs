using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ServerSD.AutoMapper
{
    public class ModelToServiceModelProfile: Profile
    {
        public override string ProfileName
        {
            get{return "ModelToServiceModelMappings";}
        }

        protected override void Configure()
        {
            Mapper.CreateMap<Models.ClienteD,Models.ServiceModel.ClienteD>();
            Mapper.CreateMap<Models.DescricaoArquivo, Models.ServiceModel.DescricaoArquivo>();
            Mapper.CreateMap<Models.ItemBuscaNome, Models.ServiceModel.ItemBuscaNome>();
        }
    }
}