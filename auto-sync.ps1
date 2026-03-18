# Auto-sync script for GitHub repository
# This script watches for file changes and automatically commits and pushes them

$repoPath = "c:\Users\shrut\OneDrive\Desktop\java"
$debounceTime = 2000  # Wait 2 seconds after last change before committing

Set-Location $repoPath

Write-Host "Starting auto-sync for Java repository..." -ForegroundColor Green
Write-Host "Watching for changes... Press Ctrl+C to stop" -ForegroundColor Yellow

$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = $repoPath
$watcher.IncludeSubdirectories = $true
$watcher.EnableRaisingEvents = $true

$lastChangeTime = [DateTime]::MinValue

Register-ObjectEvent -InputObject $watcher -EventName "Changed" -Action {
    $global:lastChangeTime = Get-Date
} | Out-Null

Register-ObjectEvent -InputObject $watcher -EventName "Created" -Action {
    $global:lastChangeTime = Get-Date
} | Out-Null

Register-ObjectEvent -InputObject $watcher -EventName "Deleted" -Action {
    $global:lastChangeTime = Get-Date
} | Out-Null

$global:lastChangeTime = [DateTime]::MinValue

while ($true) {
    Start-Sleep -Milliseconds 500
    
    if ($global:lastChangeTime -ne [DateTime]::MinValue) {
        $timeSinceChange = (Get-Date) - $global:lastChangeTime
        
        if ($timeSinceChange.TotalMilliseconds -gt $debounceTime) {
            Write-Host "`n[$(Get-Date -Format 'HH:mm:ss')] Changes detected. Committing and pushing..." -ForegroundColor Cyan
            
            # Stage all changes
            git add .
            
            # Commit with timestamp
            $commitMessage = "Auto-sync: $(Get-Date -Format 'yyyy-MM-dd HH:mm:ss')"
            $commitOutput = git commit -m $commitMessage 2>&1
            
            if ($LASTEXITCODE -eq 0) {
                Write-Host "Committed: $commitMessage" -ForegroundColor Green
                
                # Push to GitHub
                $pushOutput = git push 2>&1
                if ($LASTEXITCODE -eq 0) {
                    Write-Host "Pushed to GitHub successfully" -ForegroundColor Green
                } else {
                    Write-Host "Push failed: $pushOutput" -ForegroundColor Red
                }
            } else {
                Write-Host "No changes to commit" -ForegroundColor Gray
            }
            
            $global:lastChangeTime = [DateTime]::MinValue
        }
    }
}
