const repositoriesFileName = "repositorios.txt"

// Opens a file and handles errors appropriately.
func openRepositoriesFile(fileName string) (*os.File, error) {
file, err := os.Open(fileName)
if err != nil {
return nil, fmt.Errorf("erro ao abrir o arquivo: %w", err)
}
return file, nil
}

// Main function
func main() {
repoFile, err := openRepositoriesFile(repositoriesFileName)
if err != nil {
fmt.Println(err)
return
}
defer repoFile.Close()

// Leitor de scanner para ler o arquivo linha por linha
scanner := bufio.NewScanner(repoFile)
for scanner.Scan() {
repoURL := strings.TrimSpace(scanner.Text())
if repoURL == "" {
continue
}

// Extraindo o nome do repositório da URL SSH
parts := strings.Split(repoURL, "/")
repoName := parts[len(parts)-1]
if strings.HasSuffix(repoName, ".git") {
repoName = repoName[:len(repoName)-4]
}

// Clonar o repositório usando SSH
fmt.Println("Clonando repositório via SSH:", repoURL)
cmd := exec.Command("git", "clone", repoURL)
cmd.Stdout = os.Stdout
cmd.Stderr = os.Stderr
if err := cmd.Run(); err != nil {
fmt.Println("Erro ao clonar o repositório:", err)
continue
}

// Deletar o repositório clonado
fmt.Println("Deletando repositório:", repoName)
if err := os.RemoveAll(repoName); err != nil {
fmt.Println("Erro ao deletar o repositório:", err)
}
}

if err := scanner.Err(); err != nil {
fmt.Println("Erro ao ler o arquivo:", err)
}
}