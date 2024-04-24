import express from 'express';
import * as http from 'http';
import * as path from 'path';

const app = express();
const httpServer: http.Server = http.createServer(app);
const PORT: number = 8000;

httpServer.listen(PORT, () => {
	console.log(`Server running at http://localhost:${PORT}/`);
});

app.get('/api/projets', () => {
	
});

app.get('/api/projets/:id', () => {
	
});

app.post('/api/projets', () => {
	
});

const publicDirectoryPath = path.join(process.cwd(), 'client', 'public');
app.use(express.static(publicDirectoryPath));
