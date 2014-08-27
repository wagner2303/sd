namespace ServerSD.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("DescricaoArquivo")]
    public partial class DescricaoArquivo
    {
        public DescricaoArquivo()
        {
            ItemBuscaNome = new HashSet<ItemBuscaNome>();
            ClienteD = new HashSet<ClienteD>();
        }

        [Key]
        [StringLength(32)]
        public string md5Arquivo { get; set; }

        public long tamanho { get; set; }

        public virtual ICollection<ItemBuscaNome> ItemBuscaNome { get; set; }

        public virtual ICollection<ClienteD> ClienteD { get; set; }
    }
}
