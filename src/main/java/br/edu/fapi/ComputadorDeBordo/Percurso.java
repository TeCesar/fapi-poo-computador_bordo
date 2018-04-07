package br.edu.fapi.ComputadorDeBordo;

public class Percurso {
    
    public void percorrerPercurso (ComputadorDeBordo computadorDeBordo) {
        int contDurabilidade = computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().getDurabilidadePneu();
        int contDurabilidadeStep = computadorDeBordo.getCarro().getPneuStep().getDurabilidadePneu();
        float autonomiaCombustivel;
        
        System.out.println("Voc� come�ou o trajeto.");
        for (int km = 1; km <= 500; km++){
            autonomiaCombustivel = (computadorDeBordo.getCarro().getTanqueDeGasolina().getLitrosAtual()- 1)*computadorDeBordo.getCarro().getTanqueDeGasolina().getAutonomiaTanque();
            if (computadorDeBordo.getCarro().getTanqueDeGasolina().getLitrosAtual() <= 0 || km == contDurabilidade){
                if (computadorDeBordo.getCarro().getTanqueDeGasolina().getLitrosAtual() <= 0){
                    System.out.println("Acabou sua gasolina. A viagem acabou.");
                    km = 500;
                }else if (km == contDurabilidade){
                    System.out.println("Seus pneus estouraram. A viagem acabou.");
                    km = 500;
                }else if (km == contDurabilidadeStep){
                    System.out.println("Seu step estourou");
                    km = 500;
                }
                
            }
            
            if (computadorDeBordo.getCarro().getTanqueDeGasolina().getLitrosAtual() > 0 && km < contDurabilidade){
            computadorDeBordo.getVerificaPercurso().diminuirGasolina(computadorDeBordo);
            
            System.out.println("km: " + km);
            System.out.println("Litros no tanque: " + computadorDeBordo.getCarro().getTanqueDeGasolina().getLitrosAtual());
            System.out.println("kms que podem ser percorridos com a gasolina atual: " +  autonomiaCombustivel);
            if (km < 400){
                System.out.println("Durabilidade dos pneus. ");
                System.out.println("Dianteiro esquerdo: " + computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().getDurabilidadePneu() + "km");
                System.out.println("Dianteiro direito: " + computadorDeBordo.getCarro().getPneuDianteiroDireito().getDurabilidadePneu() + "km");
                System.out.println("Traseiro esquerdo: " + computadorDeBordo.getCarro().getPneuTraseiroEsquerdo().getDurabilidadePneu() + "km");
                System.out.println("Traseiro direito: " + computadorDeBordo.getCarro().getPneuTraseiroDireito().getDurabilidadePneu() + "km");
                System.out.println("");
                computadorDeBordo.getVerificaPercurso().diminuiDurabilidadePneu(computadorDeBordo, km);
                
                if (km == 220 && computadorDeBordo.getVerificaPercurso().verificarTetoSolar(computadorDeBordo) == true){
                    System.out.println("Voc� abriu o teto solar.");
                    System.out.println("");
                }
                if (km == 240 && computadorDeBordo.getVerificaPercurso().verificarTetoSolar(computadorDeBordo) == true){
                    System.out.println("Voc� fechou o teto solar.");
                    System.out.println("");
                }
           
                if (km == 350 && computadorDeBordo.getVerificaPercurso().verificarTetoSolar(computadorDeBordo) == true){
                    System.out.println("Voc� abriu o teto solar.");
                    System.out.println("");
                }
           
                if (km == 390 && computadorDeBordo.getVerificaPercurso().verificarTetoSolar(computadorDeBordo) == true){
                    System.out.println("Voc� fechou o teto solar.");
                    System.out.println("");
                }
                
                if (km == 370 && computadorDeBordo.getVerificaPercurso().verificarBluetooth(computadorDeBordo) == true){
                    System.out.println("Realizando chamada para o aparelho conectado ao bluetooth.");
                    System.out.println("");
                }else if (km == 370 && computadorDeBordo.getVerificaPercurso().verificarBluetooth(computadorDeBordo) == false){
                    System.out.println("Voc� n�o possui Bluetooth para realizar liga��es");
                }
            }else if (km == 400){
                if (computadorDeBordo.getCarro().getPneuStep().isStep() == true){
                    System.out.println("");
                    System.out.println("Seu pneu traseiro direito furou, substituindo pneu pelo step.");
                    System.out.println("Durabilidade dos pneus. ");
                    System.out.println("Dianteiro esquerdo: " + computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().getDurabilidadePneu() + "km");
                    System.out.println("Dianteiro direito: " + computadorDeBordo.getCarro().getPneuDianteiroDireito().getDurabilidadePneu() + "km");
                    System.out.println("Traseiro esquerdo: " + computadorDeBordo.getCarro().getPneuTraseiroEsquerdo().getDurabilidadePneu() + "km");
                    System.out.println("Step: " + computadorDeBordo.getCarro().getPneuStep().getDurabilidadePneu() + "km");
                    System.out.println("");
                    computadorDeBordo.getVerificaPercurso().diminuiDurabilidadePneu(computadorDeBordo, km);
                    computadorDeBordo.getVerificaPercurso().diminuiDurabilidadePneu_Step(computadorDeBordo);
                }else{
                    System.out.println("Seu pneu furou e o carro n�o possui step. A viagem acabou.");
                }
            }else if (km > 400 && computadorDeBordo.getCarro().getPneuStep().isStep() == true){
                System.out.println("Durabilidade dos pneus. ");
                System.out.println("Dianteiro esquerdo: " + computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().getDurabilidadePneu() + "km");
                System.out.println("Dianteiro direito: " + computadorDeBordo.getCarro().getPneuDianteiroDireito().getDurabilidadePneu() + "km");
                System.out.println("Traseiro esquerdo: " + computadorDeBordo.getCarro().getPneuTraseiroEsquerdo().getDurabilidadePneu() + "km");
                System.out.println("Step: " + computadorDeBordo.getCarro().getPneuStep().getDurabilidadePneu() + "km");
                System.out.println("");
                
                computadorDeBordo.getVerificaPercurso().diminuiDurabilidadePneu(computadorDeBordo, km);
                computadorDeBordo.getVerificaPercurso().diminuiDurabilidadePneu_Step(computadorDeBordo);
            }else {
                System.out.println("");
                System.out.println("Sua viagem acabou.");
                km = 500;
            }
        }
        }
    }
    
}

