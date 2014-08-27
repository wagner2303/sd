namespace ServerSD.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ClienteD")]
    public partial class ClienteD
    {
        public ClienteD()
        {
            DescricaoArquivo = new HashSet<DescricaoArquivo>();
        }

        [Key]
        [StringLength(15)]
        public string endereco { get; set; }

        public virtual ICollection<DescricaoArquivo> DescricaoArquivo { get; set; }
    }
}
