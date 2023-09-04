// Personagem.java

public class Personagem {
    private String nome;
    private int energia;
    private int vida;

    public Personagem(String nome, int energia, int vida) {
        this.nome = nome;
        setEnergia(energia);
        setVida(vida);
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    private void setEnergia(int energia) {
        if (energia >= 0) {
            this.energia = energia;
        } else {
            throw new IllegalArgumentException("Energia não pode ser negativa.");
        }
    }

    public int getVida() {
        return vida;
    }

    private void setVida(int vida) {
        if (vida >= 0) {
            this.vida = vida;
        } else {
            throw new IllegalArgumentException("Vida não pode ser negativa.");
        }
    }

    public void tomarDano(int dano) {
        if (dano > 0) {
            if (energia >= dano) {
                energia -= dano;
            } else {
                energia = 0;
                vida -= dano - energia;
            }
        }
    }

    public void ganharEnergia(int energia) {
        if (energia > 0) {
            this.energia += energia;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEnergia: " + energia + "\nVida: " + vida;
    }
}
