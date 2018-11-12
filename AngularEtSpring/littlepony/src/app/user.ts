export class User {
    id: number;
    nom: string;
    password: string = 'motdepasse';
    role: string = 'ROLE_USER';

    constructor(nom?: string, password?: string, role?: string)
    {
        this.id = 0;
        this.nom = nom === undefined ? 'nom' : nom ;
        this.password = password === undefined ? 'password' : password ;
        this.role = role === undefined ? 'ROLE_USER' : role ;
    }
}
