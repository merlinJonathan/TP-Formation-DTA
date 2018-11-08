export class User {
    logging: string;
    pass: string = 'motdepasse';

    constructor(logging: string)
    {
        this.logging = logging;
    }
}
