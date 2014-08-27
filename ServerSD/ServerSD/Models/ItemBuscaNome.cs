namespace ServerSD.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ItemBuscaNome")]
    public partial class ItemBuscaNome
    {
        [Key]
        [Column(TypeName = "numeric")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public decimal idItemBuscaNome { get; set; }

        [Required]
        [StringLength(32)]
        public string md5Arquivo { get; set; }

        [Column(TypeName = "text")]
        [Required]
        public string nome { get; set; }

        public virtual DescricaoArquivo DescricaoArquivo { get; set; }
    }
}
