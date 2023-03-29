public class Carga {

        private int qtdDeCelulares = 0;
        private int qtdDeGeladeiras = 0;
        private int qtdDeFrezzers = 0;
        private int qtdDeCadeiras = 0;
        private int qtdDeLuminarias = 0;
        private int qtdLavaRoupa = 0;
        private double pesoRemovido=0;
        private double cargaTotal = 0.0;
        private int distancia = 0;
        private int distancia12=0;
        private int distancia23=0;
      
        private String cidade1 ;
        private String cidade2 ;
        private String cidade3 ;

        // Construtor
        public Carga(int qtdDeCelulares, int qtdDeGeladeiras, int qtdDeFrezzers, int qtdDeCadeiras, int qtdDeLuminarias,
                        int qtdLavaRoupa) {
                this.qtdDeCadeiras = this.qtdDeCadeiras + qtdDeCadeiras;
                this.qtdLavaRoupa = this.qtdLavaRoupa + qtdLavaRoupa;
                this.qtdDeLuminarias = this.qtdDeLuminarias + qtdDeLuminarias;
                this.qtdDeGeladeiras = this.qtdDeGeladeiras + qtdDeGeladeiras;
                this.qtdDeFrezzers = this.qtdDeFrezzers + qtdDeFrezzers;
                this.qtdDeCelulares = this.qtdDeCelulares + qtdDeCelulares;
        }

        public Carga(int distancia, String cidade1, String cidade2) {
                this.distancia = distancia;
                this.cidade1 = cidade1;
                this.cidade2 = cidade2;
        }

        public Carga(int distancia, String cidade1, String cidade2, String cidade3,int distancia12,int distancia23) {
                this.distancia = distancia;
                this.cidade1 = cidade1;
                this.cidade2 = cidade2;
                this.cidade3 = cidade3;
                this.distancia12=distancia12;
                this.distancia23=distancia23;
        }

        // Setts
        public void setRESETATUDO() {
                this.qtdDeCadeiras = 0;
                this.qtdLavaRoupa = 0;
                this.qtdDeLuminarias = 0;
                this.qtdDeGeladeiras = 0;
                this.qtdDeFrezzers = 0;
                this.qtdDeCelulares = 0;
        }
        

        public void setPesoRemovido(double pesoRemovido) {
                this.pesoRemovido = this.pesoRemovido+pesoRemovido;
        }
        public void setCidade3(String cidade3) {
                this.cidade3 = cidade3;
        }

        public void setRedQtdDeCadeiras(int intensEntregues) {
                this.qtdDeCadeiras = qtdDeCadeiras - intensEntregues;
        }

        public void setRedQtdLavaRoupa(int intensEntregues) {
                this.qtdLavaRoupa = qtdLavaRoupa - intensEntregues;

        }

        public void setRedQtdLuminarias(int intensEntregues) {
                this.qtdDeLuminarias = qtdDeLuminarias - intensEntregues;

        }

        public void setRedQtdDeGeladeiras(int intensEntregues) {
                this.qtdDeGeladeiras = qtdDeGeladeiras - intensEntregues;
        }

        public void setRedQtdDeFrezzers(int intensEntregues) {
                this.qtdDeFrezzers = qtdDeFrezzers - intensEntregues;
        }

        public void setRedQtdDeCelulares(int intensEntregues) {
                this.qtdDeCelulares = qtdDeCelulares - intensEntregues;
        }

        //
        public void setAddQtdDeCadeiras(int qtdDeCadeiras) {
                this.qtdDeCadeiras = qtdDeCadeiras;
        }

        public void setAddQtdLavaRoupa(int qtdLavaRoupa) {
                this.qtdLavaRoupa = qtdLavaRoupa;

        }

        public void setAddQtdLuminarias(int qtdDeLuminarias) {
                this.qtdDeLuminarias = qtdDeLuminarias;

        }

        public void setAddQtdDeGeladeiras(int qtdDeGeladeiras) {
                this.qtdDeGeladeiras = qtdDeGeladeiras;
        }

        public void setAddQtdDeFrezzers(int qtdDeFrezzers) {
                this.qtdDeFrezzers = qtdDeFrezzers;
        }

        public void setAddQtdDeCelulares(int qtdDeCelulares) {
                this.qtdDeCelulares = qtdDeCelulares;
        }

        public void setDistancia(int distancia) {
                this.distancia = distancia;
        }

        public void setCidade1(String cidade1) {
                this.cidade1 = cidade1;
        }

        public void setCidade2(String cidade2) {
                this.cidade2 = cidade2;
        }
        public void setDistancia12(int distancia12) {
                this.distancia12 = distancia12;
        }
        public void setDistancia23(int distancia23) {
                this.distancia23 = distancia23;
        }

        //
        // Gets
        public int getSomaDosItens() {
                return qtdDeCadeiras + qtdDeCelulares + qtdDeFrezzers + qtdDeGeladeiras + qtdDeLuminarias
                                + qtdLavaRoupa;
        }

        public double getPesoRemovido() {
                return pesoRemovido;
        }
        public int getQtdDeCadeiras() {
                return qtdDeCadeiras;

        }

        public String getCidade3() {
                return cidade3;
        }

        public int getQtdLavaRoupa() {
                return qtdLavaRoupa;

        }

        public int getQtdLuminarias() {
                return qtdDeLuminarias;

        }

        public int getQtdDeGeladeiras() {
                return qtdDeGeladeiras;

        }

        public int getQtdDeFrezzers() {
                return qtdDeFrezzers;
        }

        public int getQtdDeCelulares() {
                return qtdDeCelulares;
        }

       

        public String getCidade1() {
                return cidade1;
        }

        public String getCidade2() {
                return cidade2;
        } 
        public int getDistancia() {
                return distancia;
        }
        public int getDistancia12() {
                return distancia12;
        }

        
        public int getDistancia23() {
                return distancia23;
        }
        


        //
        // Soma todos os itens para ver o peso
        public double calcularCargaTotalTrecho1() {
                cargaTotal = this.qtdDeCadeiras * 5.0 +
                                this.qtdLavaRoupa * 120.0 +
                                this.qtdDeLuminarias * 0.8 +
                                this.qtdDeGeladeiras * 60.0 +
                                this.qtdDeFrezzers * 100.0 +
                                this.qtdDeCelulares * 0.5;
                return cargaTotal;
        }
        public double calcularCargaTotalTrecho2() {
                cargaTotal = this.qtdDeCadeiras * 5.0 +
                                this.qtdLavaRoupa * 120.0 +
                                this.qtdDeLuminarias * 0.8 +
                                this.qtdDeGeladeiras * 60.0 +
                                this.qtdDeFrezzers * 100.0 +
                                this.qtdDeCelulares * 0.5;
                return cargaTotal;
        }       
         
        

}
