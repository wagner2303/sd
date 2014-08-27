using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ServerSD.AutoMapper
{
    public class ServiceModelToModelProfile : Profile
    {
        public override string ProfileName
        {
            get { return "ServiceModelToModelProfile"; }
        }

        protected override void Configure()
        {
            Mapper.CreateMap<Models.ServiceModel.ClienteD, Models.ClienteD>();
            Mapper.CreateMap<Models.ServiceModel.DescricaoArquivo,Models.DescricaoArquivo>();
            Mapper.CreateMap<Models.ServiceModel.ItemBuscaNome,Models.ItemBuscaNome>();
        }
    }
}