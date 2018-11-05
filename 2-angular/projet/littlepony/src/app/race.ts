import { Pony } from './pony';

export class Race {
    id: number;
    location: string;
    date: Date;
    ponies: Array<Pony>;

    constructor(location?: string, date?: Date)
    {
        this.id = 0;
        this.ponies = [];
        this.location = location === undefined ? '' : location;
        this.date = date === undefined ? new Date() : date;
    }
}
