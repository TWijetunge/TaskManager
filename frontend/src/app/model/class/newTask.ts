export class NewTask {
    title: string;
    description: string;
    status: string;
    createdAt: Date;

    constructor(){
        this.title="";
        this.description="";
        this.status="";
        this.createdAt= new Date();

    }
}