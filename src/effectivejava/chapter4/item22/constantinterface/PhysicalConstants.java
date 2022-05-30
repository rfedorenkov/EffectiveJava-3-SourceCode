package effectivejava.chapter4.item22.constantinterface;

// Антишаблон интерфейса констант - не используйте его!
public interface PhysicalConstants {
    // Число Авогадро (1/mol)
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;

    // Постоянная Больцмана (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    // Масса электрона (kg)
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}